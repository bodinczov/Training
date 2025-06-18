package org.training.collections;

public class MyArrayList<T> {
    private T[] array;
    private int size;
    private int capacity;

    public MyArrayList() {
        T[] firstArray = (T[]) new Object[10];
        this.size = 0;
        this.capacity = 10;
        this.array = firstArray;
    }

    public void add(T value) {
        if (capacity == size) {
            increaseCapacity();
        }
        array[size] = value;
        size++;
    }

    public void increaseCapacity() {
        this.capacity *= 2;
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        this.array = newArray;
    }

    public void add(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == capacity) {
            increaseCapacity();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    public void remove(T value) {
        boolean removed = false;
        for (int i = 0; i < size; i++) {
            if (!removed && array[i].equals(value)) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = null;
                size--;
                removed = true;
                break;
            }
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}

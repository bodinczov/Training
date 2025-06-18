package org.training.collections.MyLinkedList;

public class MyLinkedList<T> {
    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    public MyLinkedList(){}

    public void addFirst(T value){
        if(first == null){
            var firstNode = new Node<T>(value);
            this.first = firstNode;
            this.last = firstNode;
            size++;
        } else {
            var newFirst = new Node<T>(null, value, first);
            first.setPrevValue(newFirst);
            this.first = newFirst;
            size++;
        }
    }

    public void addLast(T value){
        if(last == null){
            var firstNode = new Node<T>(value);
            this.first = firstNode;
            this.last = firstNode;
            size++;
        } else {
            var newLast = new Node<T>(last, value, null);
            last.setNextValue(newLast);
            this.last = newLast;
            size++;
        }
    }

    public void add(int index, T value){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == size){
            addLast(value);
            return;
        } else if (index == 0){
            addFirst(value);
            return;
        }
        Node<T> current;
        if(index < size / 2){
            current = first;
            for(int i = 0; i < index; i++){
                current = current.getNextValue();
            }
        } else {
            current = last;
            for(int i = size-1; i > index; i--){
                current = current.getPrevValue();
            }
        }
        Node<T> prevNode = current.getPrevValue();
        Node<T> newNode = new Node<>(prevNode, value, current);
        prevNode.setNextValue(newNode);
        current.setPrevValue(newNode);
        size++;
    }

    public void removeFirst(){
        if(size >= 1) {
            var newFirst = first.getNextValue();
            this.first = newFirst;
            size--;
        }
    }

    public void removeLast(){
        if(size >= 1) {
            var newLast = last.getPrevValue();
            this.last = newLast;
            size--;
        }
    }

    public void remove(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == size-1){
            removeLast();
            return;
        } else if (index == 0){
            removeFirst();
            return;
        }
        Node<T> current;
        if(index < size / 2){
            current = first;
            for(int i = 0; i < index; i++){
                current = current.getNextValue();
            }
        } else {
            current = last;
            for(int i = size-1; i > index; i--){
                current = current.getPrevValue();
            }
        }
        var prevNode = current.getPrevValue();
        var nextNode = current.getNextValue();
        prevNode.setNextValue(nextNode);
        nextNode.setPrevValue(prevNode);
        size--;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = first;
        for(int i = 0; i < size; i++){
            sb.append(String.valueOf(current.getValue()));
            current = current.getNextValue();
            if(i != size-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public T getFirst(){
        return first.getValue();
    }

    public T getLast(){
        return last.getValue();
    }

    public int getSize() {
        return size;
    }
}

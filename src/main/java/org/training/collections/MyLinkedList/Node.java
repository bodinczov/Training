package org.training.collections.MyLinkedList;

public class Node<T> {
    private T value;
    private Node<T> nextValue;
    private Node<T> prevValue;

    public Node(Node<T> prevValue, T value, Node<T> nextValue){
        this.prevValue = prevValue;
        this.value = value;
        this.nextValue = nextValue;
    }
    public Node(T value){
        this.prevValue = null;
        this.value = value;
        this.nextValue = null;
    }

    public void setPrevValue(Node<T> prev){
        this.prevValue = prev;
    }

    public void setNextValue(Node<T> nextValue) {
        this.nextValue = nextValue;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNextValue() {
        return nextValue;
    }

    public Node<T> getPrevValue() {
        return prevValue;
    }
}

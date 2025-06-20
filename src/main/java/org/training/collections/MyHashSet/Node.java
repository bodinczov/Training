package org.training.collections.MyHashSet;

public class Node<T> {
    private final int hash;
    private T value;
    private Node<T> next;

    Node(int keyHash, T value, Node<T> next) {
        this.hash = keyHash;
        this.value = value;
        this.next = next;
    }

    public int getHash() {
        return hash;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext(){
        return this.next;
    }
}

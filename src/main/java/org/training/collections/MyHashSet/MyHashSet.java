package org.training.collections.MyHashSet;

import java.util.Objects;
//                                            ToDo: make tests in main
public class MyHashSet<T> {
    private Node<T>[] bucket;
    private int size;
    private final int DEFAULT_CAPACITY = 16;
    private final double LOAD_FACTOR = 0.75;

    public MyHashSet(){
        bucket = (Node<T>[]) new Node[DEFAULT_CAPACITY];
    }

    public int computeHash(T value){
        return value == null ? 0 : value.hashCode();
    }

    public int bucketIndex(int hash){
        return Math.floorMod(hash, bucket.length);
    }

    public void put(T value){
        int hash = computeHash(value);
        int index = bucketIndex(hash);
        Node<T> currentNode = bucket[index];
        if(currentNode == null){
            bucket[index] = new Node<T>(hash, value, null);
            size++;
                if(size > bucket.length * LOAD_FACTOR){
                    resize();
                }
            return;
        }
        for(int i = 0; currentNode != null; i++){
            if(currentNode.getHash() == hash && Objects.equals(currentNode.getValue(), value)){
                throw new RuntimeException("Value already exists");
            }
            if(currentNode.getNext() == null){
                currentNode.setNext(new Node<T>(hash, value, null));
                size++;
                if(size > bucket.length * LOAD_FACTOR){
                    resize();
                }
                return;
            }
            currentNode = currentNode.getNext();
        }
    }

    public boolean contains(T value){
        int hash = computeHash(value);
        int index = bucketIndex(hash);
        Node<T> currentNode = bucket[index];
        for(int i = 0; currentNode != null; i++){
            if(currentNode.getHash() == hash && Objects.equals(currentNode.getValue(), value)){
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public void remove(T value){
        int hash = computeHash(value);
        int index = bucketIndex(hash);
        Node<T> currentNode = bucket[index];
        Node<T> previousNode = null;

        for(int i = 0; currentNode != null; i++){
            if(currentNode.getHash() == hash && Objects.equals(currentNode.getValue(), value)){
                if(previousNode == null){
                    bucket[index] = currentNode.getNext();
                } else {
                    previousNode.setNext(currentNode.getNext());
                }
                size--;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
    }

    private void resize() {
        int newCapacity = bucket.length * 2;
        Node<T>[] oldBucket = bucket;
        bucket = (Node<T>[]) new Node[newCapacity];
        for(Node<T> head : oldBucket){
            while(head != null){
                Node<T> next = head.getNext();
                int newIndex = bucketIndex(head.getHash());
                head.setNext(bucket[newIndex]);
                bucket[newIndex] = head;
                head = next;
            }
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for(Node<T> node : bucket){
            while(node != null){
                if(!first){
                    sb.append(", ");
                }
                sb.append(node.getValue());
                first = false;
                node = node.getNext();
            }
        }
        sb.append("]");
        return sb.toString();
    }

}


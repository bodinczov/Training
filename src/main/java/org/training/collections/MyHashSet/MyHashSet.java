package org.training.collections.MyHashSet;

import java.util.Objects;

public class MyHashSet<T> {
    private Node<T>[] bucket;
    private int size;

    public MyHashSet(){
        bucket = (Node<T>[]) new Node[16];
    }

    public int computeHash(T value){
        return value == null ? 0 : value.hashCode();
    }

    public int bucketIndex(int hash, int capacity){
        return Math.floorMod(hash, capacity);
    }

    public void put(T value){
        int hash = computeHash(value);
        int index = bucketIndex(hash, bucket.length);
        Node<T> currentNode = bucket[index];
        if(currentNode == null){
            bucket[index] = new Node<T>(hash, value, null);
            size++;
                if(size > bucket.length * 0.75){
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
                if(size > bucket.length * 0.75){
                    resize();
                }
                return;
            }
            currentNode = currentNode.getNext();
        }
    }

    public boolean contains(T value){
        int hash = computeHash(value);
        int index = bucketIndex(hash, bucket.length);
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
        int index = bucketIndex(hash, bucket.length);
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

    public void resize(){
        int newCapacity = bucket.length * 2;
        Node<T>[] newBucket = (Node<T>[]) new Node[newCapacity];
        for (int i = 0; i < bucket.length; i++) {
            Node<T> currentNode = bucket[i];
            for (int j = 0; currentNode != null; j++) {
                Node<T> nextNode = currentNode.getNext();
                int newIndex = bucketIndex(currentNode.getHash(), newCapacity);
                currentNode.setNext(newBucket[newIndex]);
                newBucket[newIndex] = currentNode;
                currentNode = nextNode;
            }
        }
        bucket = newBucket;
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


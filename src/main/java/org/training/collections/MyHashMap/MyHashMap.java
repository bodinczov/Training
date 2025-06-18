package org.training.collections.MyHashMap;

import java.util.Objects;

public class MyHashMap<K, V> {
    private Node<K, V>[] bucket;
    private int size;

    public MyHashMap(){
        bucket = (Node<K, V>[]) new Node[16];
    }

    public int computeHash(K key){
        return key == null ? 0 : key.hashCode();
    }

    public int bucketIndex(int hash, int capacity){
        return Math.floorMod(hash, capacity);
    }

    public void put(K key, V value){
        int hash = computeHash(key);
        int index = bucketIndex(hash, bucket.length);
        Node<K, V> currentNode = bucket[index];
        while(currentNode != null){
            if(currentNode.getHash() == hash && Objects.equals(currentNode.getKey(), key)){
                currentNode.setValue(value);
                return;
            }
            currentNode = currentNode.getNext();
        }
        bucket[index] = new Node<>(hash, key, value, bucket[index]);
        size++;
        if(size > bucket.length * 0.75){
            resize();
        }
    }

    public V get(K key){
        int hash = computeHash(key);
        int index = bucketIndex(hash, bucket.length);
        Node<K, V> currentNode = bucket[index];
        while(currentNode != null){
            if(currentNode.getHash() == hash && Objects.equals(currentNode.getKey(), key)){
                return currentNode.getValue();
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public void remove(K key){
        int hash = computeHash(key);
        int index = bucketIndex(hash, bucket.length);
        Node<K, V> currentNode = bucket[index];
        Node<K, V> previousNode = null;
        while(currentNode != null){
            if(currentNode.getHash() == hash && Objects.equals(currentNode.getKey(), key)){
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

    public boolean containsKey(K key){
        return get(key) != null;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void resize(){
        int newCapacity = bucket.length * 2;
        Node<K, V>[] newBucket = (Node<K, V>[]) new Node[newCapacity];
        for(Node<K, V> head : bucket){
            while(head != null){
                Node<K, V> next = head.getNext();
                int newIndex = bucketIndex(head.getHash(), newCapacity);
                head.setNext(newBucket[newIndex]);
                newBucket[newIndex] = head;
                head = next;
            }
        }
        bucket = newBucket;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;
        for (Node<K, V> head : bucket){
            Node<K, V> currentNode = head;
            while(currentNode != null){
                if(!first){
                    sb.append(", ");
                }
                sb.append(currentNode.getKey()).append("=").append(currentNode.getValue());
                first = false;
                currentNode = currentNode.getNext();
            }
        }
        sb.append("}");
        return sb.toString();
    }
}

package org.training;

import org.training.collections.MyArrayList;
import org.training.collections.MyHashMap.MyHashMap;
import org.training.collections.MyLinkedList.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("----- MyArrayList -----");
        MyArrayList<Integer> myArrayListTest = new MyArrayList<>();
        System.out.println(myArrayListTest);
        for (int i = 0; i < 10; i++) {
            myArrayListTest.add(i);
        }
        System.out.println("filled arr: " + myArrayListTest);
        myArrayListTest.add(10);
        System.out.println("add by val: " + myArrayListTest);
        myArrayListTest.add(5, 99);
        System.out.println("add by index: " + myArrayListTest);
        myArrayListTest.remove(99);
        System.out.println("remove by val: " + myArrayListTest);
        myArrayListTest.removeByIndex(0);
        System.out.println("remove by index: " + myArrayListTest);

        System.out.println("----- MyLinkedList -----");
        MyLinkedList<Integer> myLinkedListTest = new MyLinkedList<>();
        myLinkedListTest.addLast(1);
        myLinkedListTest.addLast(2);
        myLinkedListTest.addLast(3);
        System.out.println("addLast: " + myLinkedListTest);
        myLinkedListTest.addFirst(0);
        System.out.println("addFirst: " + myLinkedListTest);
        myLinkedListTest.add(2, 99);
        System.out.println("add by index: " + myLinkedListTest);
        myLinkedListTest.removeFirst();
        System.out.println("removeFirst: " + myLinkedListTest);
        myLinkedListTest.removeLast();
        System.out.println("removeLast: " + myLinkedListTest);
        myLinkedListTest.remove(1);
        System.out.println("remove by index: " + myLinkedListTest);
        System.out.println("First: " + myLinkedListTest.getFirst());
        System.out.println("Last: " + myLinkedListTest.getLast());
        System.out.println("Size: " + myLinkedListTest.getSize());

        System.out.println("----- MyHashMap -----");
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        System.out.println("isEmpty: " + myHashMap.isEmpty());
        System.out.println("size: " + myHashMap.size());
        myHashMap.put("One", 1);
        myHashMap.put("Two", 2);
        myHashMap.put("Three", 3);
        myHashMap.put("Four", 4);
        System.out.println("after put: " + myHashMap);
        System.out.println("size: " + myHashMap.size());
        System.out.println("get by key: " + myHashMap.get("Two"));
        myHashMap.put("Two", 22);
        System.out.println("update value: " + myHashMap);
        System.out.println("contains 'Three': " + myHashMap.containsKey("Three"));
        System.out.println("contains 'Ten': " + myHashMap.containsKey("Ten"));
        myHashMap.remove("One");
        System.out.println("after remove: " + myHashMap);
        System.out.println("size: " + myHashMap.size());
        myHashMap.put(null, 999);
        System.out.println("null key put: " + myHashMap);
        System.out.println("get null key: " + myHashMap.get(null));
    }
}
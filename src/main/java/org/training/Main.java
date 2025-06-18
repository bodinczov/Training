package org.training;

import org.training.collections.MyArrayList;
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
    }
}
package org.training;

import org.training.collections.MyArrayList;

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
    }
}
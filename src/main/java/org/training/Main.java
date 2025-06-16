package org.training;

import org.training.collections.MyArrayList;
import org.training.collections.MyHashMap.MyHashMap;
import org.training.collections.MyLinkedList.MyLinkedList;

public class Main {
    public static void main(String[] args) {
       System.out.println("----- MyArrayList -----");
       MyArrayList<Integer> a = new MyArrayList<Integer>();
       for(int i = 0; i < 11; i++){
           a.add(i);
       }
       System.out.println(a);
       a.remove(10);
       System.out.println(a);
       a.add(10, 10);
       System.out.println(a);
    }
}

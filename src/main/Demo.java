package main;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(10);
        myArrayList.add(11);
        myArrayList.add(12);
        System.out.println("myArrayList.getSize() = " + myArrayList.size());
        System.out.println("myArrayList.getLength() = " + myArrayList.getLength());
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
        myArrayList.remove(1);
        System.out.println("myArrayList.getSize() = " + myArrayList.size());
        System.out.println("myArrayList.getLength() = " + myArrayList.getLength());
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
        myArrayList.clear();
        System.out.println("myArrayList.getSize() = " + myArrayList.size());
        System.out.println("myArrayList.getLength() = " + myArrayList.getLength());
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i));
        }
    }
}

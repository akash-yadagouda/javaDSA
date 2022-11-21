package com.company.LinkedListByAkash;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedListByAkash list = new LinkedListByAkash();
        list.add(10);
        list.add(100);
        list.add(123);
        list.add(2019);
        list.display();
        list.delete(0);
        System.out.println("after deletion");
        list.display();
    }
}

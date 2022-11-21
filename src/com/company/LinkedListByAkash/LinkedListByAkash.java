package com.company.LinkedListByAkash;

public class LinkedListByAkash {
    private NodeByAkash head;
    private NodeByAkash tail;


    public void add(int data) {

        NodeByAkash node = new NodeByAkash(data);

        if(this.head == null){
            this.head = node;
            this.tail = node;
            System.out.println("data inserted successfully :");
            return;
        }
        this.tail.setNext(node);
        this.tail = this.tail.getNext();
        System.out.println("data inserted successfully");
    }

    public void display() {
        if (this.head == null) {
            System.out.println("list is null");
            return;
        }
        NodeByAkash tempNode;

        tempNode = this.head;
        while (tempNode != null) {
            System.out.print("->" + tempNode.getData());
            tempNode = tempNode.getNext();
        }
    }

    /*
    * 1->2->3->4->5->
    * index = 3
    *
    * loop till index - 1
    * override the next value of the node at index (index-1) with next value of index;
    *
    *
    *
    * */

    public void delete(int index){
        NodeByAkash temp = this.head;
        if(temp == null) {
            System.out.println("deletion is not possible");
            return;
        }

        if(index == 0){
            this.head = this.head.getNext();
            return;
        }

        for(int i=0; i<index-1; i++){
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
    }

}

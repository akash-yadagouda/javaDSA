package com.company.LinkedListByAkash;

public class NodeByAkash {
    private int data;
    private NodeByAkash next;

    public NodeByAkash(){
        this.data = 0;
        this.next = null;
    }

    public NodeByAkash(int data){
        this.data = data;
        this.next = null;
    }

    public NodeByAkash(int data, NodeByAkash node){
        this.data = data;
        this.next = node;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeByAkash getNext() {
        return next;
    }

    public void setNext(NodeByAkash next) {
        this.next = next;
    }
}

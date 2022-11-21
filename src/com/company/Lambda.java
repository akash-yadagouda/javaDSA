package com.company;

import java.util.ArrayList;

public class Lambda {

    public static int operate(int a , int b , Opertions op){
        return op.ops(a,b);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<10; i++){
            arr.add(i);
        }

        arr.forEach((a) -> System.out.println(a*2) );

        Opertions sum = (a, b) -> (a * b);

        System.out.println("Lambda.operate(10,20) = " + Lambda.operate(10, 20, sum));
    }
}

interface Opertions{
    int ops(int a, int b);
}
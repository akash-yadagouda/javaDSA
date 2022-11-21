package com.company.OOPs.Inheritance;

public class B  extends A{

    int b;
    int c;

    public B(int a, int b) {
        super(a);
        this.b = b;
    }

    B(int c, int b,int a){
        this.b = b;
        this.c = c;
    }

}

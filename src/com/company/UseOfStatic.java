package com.company;

public class UseOfStatic {

    // create a inner class
    static class Test {

        String Name;

        Test() {
        }

        Test(String name) {
            Name = name;
        }
    }

    public static void main(String[] args) {

        Test test = new Test("akash");

        Test test1 = new Test("rahul");

        System.out.println(test);

    }

}

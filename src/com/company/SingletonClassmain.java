package com.company;

class SingletonClass {
    public String name;
    public static SingletonClass instance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private SingletonClass() {
        this.name = "akash";
    }

    public static SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }

}

public class SingletonClassmain {
    public static void main(String[] args) {
        SingletonClass singletonClass = SingletonClass.getInstance();
        System.out.println("singletonClass.getName() = " + singletonClass.getName());
        System.out.println("singletonClass = " + singletonClass);

        SingletonClass singletonClass1 = SingletonClass.getInstance();
        System.out.println("singletonClass.getName() = " + singletonClass1.getName());
        System.out.println("singletonClass1 = " + singletonClass1);
    }
}

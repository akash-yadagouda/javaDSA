package com.company.OOPs.Abstarction;

public class Student extends StudentOps implements StudentInterface, StudentIntereface2  {

    String name;
    int rollNumber;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    @Override
    public void admission() {
        System.out.println("got addmission");
    }

    @Override
    public void assignRollNumber() {

        System.out.println("roll number assigned");

    }

    @Override
    public void getStudentInfo() {
        System.out.println("here is the student");
    }

    @Override
    public void getStudentInfoFromInterface(){
        System.out.println("we got the student infomation");
    }


}

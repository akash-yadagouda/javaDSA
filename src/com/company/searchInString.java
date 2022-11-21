package com.company;

import java.util.Scanner;

public class searchInString {
    public static void main(String[] args) {

        String name;
        Scanner input = new Scanner(System.in);
        name = input.nextLine();
        System.out.println(name.chars().findFirst());
        System.out.println(searchInString(name, 's'));
    }
    static int searchInString(String st, char s){
        if(st.isEmpty() || st.isBlank()){
            System.out.println("search String is not in valid format");
            return -1;
        }
        for (int i = 0; i < st.length(); i++) {
            if(st.charAt(i) == s){
                return i;
        }
        }
        return -1;
    }
}

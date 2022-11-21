package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LinerSeach {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = {12,23,56,78,9};
        List<Integer> intArray = List.of(12,23,56,78,9);
        System.out.println("intArray.stream().filter(c -> c == 23) = " + intArray.stream().anyMatch(c -> c.equals(23)));
        System.out.println("intArray.contains(50) = " + intArray.contains(12));
        System.out.println("linearSearch(arr,4) = " + linearSearch(arr, 56));
    }

    static int linearSearch(int[] arr, int searchkey) {
        if (arr.length == 0) {
            return -1;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == searchkey) {
                    return i;
                }
            }
        }
        return -1;
    }
}

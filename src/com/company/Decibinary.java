package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;

public class Decibinary {
    public static List<Integer> splitIntToDigits(Integer number) {

        List<Integer> digits = new ArrayList<>();

        while (number > 0) {
            digits.add(number % 10);
            number = number / 10;
        }

        System.out.println("digits = " + digits);

        return digits;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
//
        var a = number.chars().max().getAsInt() - '0';

    }
}

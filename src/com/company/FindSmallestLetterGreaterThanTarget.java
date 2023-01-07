package com.company;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] arr = {'c', 'f', 'j'};
        char target = 'c';
//        char[] arr = {'e','e','e','e','e','e','n','n','n','n'};
//        char target = 'e';
        System.out.println("ans(arr,target) = " + arr[ans(arr, target)]);

    }

    public static int ans(char[] arr, char target) {
        int start, mid, end;
        start = 0;
        end = arr.length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return (start - 1) % arr.length;
            }
        }
        return start % arr.length;
    }
}

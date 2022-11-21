package com.company;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int[] arr_reverse = {6,5,4,3,2,1};
        int target = 3;
        System.out.println("BS(arr,target) = " + BS(arr, target));
        System.out.println("BS(arr_reverse,target) = " + BS(arr_reverse, target));
    }
    private static int BS(int[] arr, int target){

        int start = 0;
        int end = arr.length;
        int mid ;
        // order agnostic bs
        boolean isAscending = arr[0] < arr[arr.length-1];

        while (start <= end) {

            mid = start + (end - start) / 2;
            if(mid > arr.length -1 ){
                return -1 ;
            }
            if (isAscending) {
                if (arr[mid] < target) {
                    start = mid + 1;
                } else if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            } else {
                if (arr[mid] > target) {
                    start = mid + 1;
                } else if (arr[mid] < target) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}

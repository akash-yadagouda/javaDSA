package com.company;
import java.util.ArrayList;
import java.util.List;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {

//        int[] arr = {2,5,6};
//        int k = 10;
        // ans = 4 + 10 - 3 = 11
        // [ 1,3,4]


//        int[] arr = {2};
//        int k = 10;
        // [1]
        // ans = 11


//        int[] arr = {1,2};
//        int k = 10;
        // ans 12

//        int[] arr = {100,230303};
//        int k = 2;
        // ans = 2;


//        int[] arr = {2,3,4,7,11};
//        int k = 5;


        int[] arr = {5,6,7,8,9};
        int k = 9;
        // [1,2,3,4,10,11,
        //


        System.out.println("kthissingPositiveNumber(arr,k) = " + kthissingPositiveNumber(arr, k));

    }
    static int kthissingPositiveNumber(int[] arr, int k){
        List<Integer> missingNumbers = new ArrayList<>();
        if(arr.length == 1){
            // if k is greater than element then
            // return k-1;
            if(k >= arr[0]){
                return k+1;
            }
            return k;
        }
        else{
            popolateArray(missingNumbers,0,arr[0]);
            for (int i = 0; i < arr.length -1 ; i++) {
                popolateArray(missingNumbers,arr[i], arr[i+1]);
                if(missingNumbers.size() > k){
                    System.out.println("missingNumbers = " + missingNumbers);
                    return missingNumbers.get(k-1);
                }
            }
        }
        // missing array has very small size
        System.out.println("missingNumbers out of for = " + missingNumbers);
        return missingNumbers.size() != 0 ?
                missingNumbers.get(missingNumbers.size()-1) + k - missingNumbers.size() :
                arr[arr.length-1]+ k - missingNumbers.size() ;


    }

    static void popolateArray(List<Integer> list, Integer start, Integer end){
        for (int i = start+1 ; i < end ; i++) {
            list.add(i);
        }
    }

}

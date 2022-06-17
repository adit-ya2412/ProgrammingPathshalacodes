package com.ac;

import java.util.Arrays;

public class insertionsort {
    public static void main(String[] args) {
        int[]arr={2,0,1,23,9,10};
        insetionsort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insetionsort(int[]arr){
        for (int i = 0; i < arr.length-1 ; i++) {
            for (int j = i+1; j >0 ; j--) {
                if (arr[j-1]>arr[j]){
                    swap(arr,j-1,j);
                }else break;
            }
        }
    }
    static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

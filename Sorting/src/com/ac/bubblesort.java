package com.ac;

import java.util.Arrays;

public class bubblesort {
    public static void main(String[] args) {
        int n=5;
        int[]arr={7,2,3,1,12};
        boolean swap=false;
        for (int i = 0; i <n ; i++) {
            swap=false;
            for (int j = 1; j <n-i ; j++) {
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                    swap=true;
                }
            }
            if (!swap)break;
        }
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

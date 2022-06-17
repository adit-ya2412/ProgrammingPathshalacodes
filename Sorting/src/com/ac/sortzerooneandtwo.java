package com.ac;

import java.util.Arrays;
import java.util.Scanner;

public class sortzerooneandtwo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        sort012(arr,n);
        System.out.println(Arrays.toString(arr));

    }
    static void sort012(int[]arr,int n){
        int piv=partition(arr,0,n-1);
        Arrays.sort(arr,piv,n);
    }
    static int partition(int[]arr,int low,int high){
        int left=low;
        int right=high;
        while (left<=right){
            while (left<=high&&(arr[left]<1)){
                left++;
            }
            while (high>=low&(arr[right]>=1)){
                right--;
            }
            if (left<right){
                swap(arr,left,right);
                left++;
                right--;
            }
        }
        return right;
    }
    static void swap(int[]arr,int left,int right){
        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
    }
}

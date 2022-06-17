package com.ac;

import java.util.Arrays;
import java.util.Scanner;

public class segregateevenandoddnumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        segregate(arr,n);
        System.out.println(Arrays.toString(arr));
    }
    static void segregate(int[]arr,int n){
         int pivot=partition(arr,0,n-1);
        Arrays.sort(arr,0,pivot+1);
        Arrays.sort(arr,pivot+1,n);
    }
    static int partition(int[]arr,int st,int end){
        int left=st;
        int right=end;
        while (left<=right){
            while (left<=end&&(arr[left]%2==0)){
                left++;
            }
            while (right>=st&&(arr[right]%2!=0)){
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

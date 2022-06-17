package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class quicksort {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        String[]elements=(in.readLine().trim()).split("\\s+");
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
//    static void quicksorting(int[]arr,int pi,int end){
//        if (pi==end)return;
//        int pivot=partition(arr,pi,end);
//        quicksorting(arr,pi,pivot);
//        quicksorting(arr,pivot+1,end);
//    }
//    static int partition(int[]arr,int pivot,int end){
//        int l=pivot+1;
//        int r= end;
//        while (l<=r){
//            while (l<=end&&arr[l]<=arr[pivot]){
//                l++;
//            }
//            while (r>=pivot&&arr[r]>arr[pivot]){
//                r--;
//            }
//            if (l<r){
//                swap(arr,l,r);
//                l++;
//                r--;
//            }
//        }
//        swap(arr,pivot,r);
//        return r;
//    }
//    static void swap(int[]arr,int l,int r){
//        int temp=arr[l];
//        arr[l]=arr[r];
//        arr[r]=temp;
//    }
    static void quickSort(int arr[], int low, int high) {
        // code here
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }
    static int partition(int arr[], int low, int high)
    {
        // your code here
        int pivot=low;
        int i=low+1;
        int j=high;
        while(i<=j){
            while(i<=high&&arr[i]<=arr[pivot]){
                i++;
            }
            while(j>=low&&arr[j]>arr[pivot]){
                j--;
            }
            if(i<j){
                swap(arr,i,j);
                i++;
                j--;
            }
        }
        swap(arr,pivot,j);
        return j;
    }
    static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

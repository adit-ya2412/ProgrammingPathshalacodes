package com.ac;

import java.util.Arrays;
import java.util.Scanner;

public class threewaypartition {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        int[]range=new int[2];
        range[0]=sc.nextInt();
        range[1]=sc.nextInt();
        threewayPartition(arr,range[0],range[1]);
        System.out.println(Arrays.toString(arr));
    }
    static void threewayPartition(int[]arr,int a,int b){

        int l=0;
        int curr=0;
        int h=arr.length-1;
        while (l<h){
            if (arr[curr]<a){
                curr++;
            }
        }
    }
    static void swap(int[]arr,int l,int h){
        int temp=arr[l];
        arr[l]=arr[h];
        arr[h]=temp;
    }
}

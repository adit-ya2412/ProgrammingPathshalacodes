package com.ac;

import java.util.Arrays;
import java.util.Scanner;

public class buildmaxheap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        int currelements=sc.nextInt();
        for(int i=0;i<currelements;i++){
            arr[i]=sc.nextInt();
            size++;
        }
        for (int i = currelements/2; i >=0 ; i--) {
            maxheapify(i,arr);
        }
        insert(23,arr);
        insert(1,arr);
        insert(10000,arr);
        insert(-12,arr);
        delete(3,arr);
        delete(5,arr);
        System.out.println(Arrays.toString(arr));
    }
    static int size;
    static void insert(int element,int[]arr){
        if (size>= arr.length) {
            System.out.println("OVerflow");
            return;
        }
        arr[size]=element;
        int i=size;
        size++;
        while (i>=0&&arr[i]>arr[i/2]){
            int temp=arr[i/2];
            arr[i/2]=arr[i];
            arr[i]=temp;
            i/=2;
        }
    }
    static void delete(int idx,int[]arr){
        arr[idx]=Integer.MAX_VALUE;
        while (idx>=0&&arr[idx]>arr[idx/2]){
            int temp=arr[idx/2];
            arr[idx/2]=arr[idx];
            arr[idx]=temp;
            idx/=2;
        }
        int temp=arr[size];
        arr[size]=arr[idx];
        arr[idx]=temp;
        size--;
        maxheapify(idx,arr);
    }
    static void maxheapify(int idx,int[]arr){
        if (idx> arr.length/2)return;
        int max=idx;
        if (arr[idx*2]>arr[max]){
            max=2*idx;
        }
        if (2*idx+1<arr.length&&arr[2*idx+1]>arr[max]){
            max=2*idx+1;
        }
        if (max!=idx){
            int temp=arr[idx];
            arr[idx]=arr[max];
            arr[max]=temp;
            maxheapify(max,arr);
        }
    }

}

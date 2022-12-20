package com.ac;

import java.util.Arrays;
import java.util.Scanner;

public class buildminheap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
         arr[i]=sc.nextInt();
        }
        for (int i =(arr.length/2);i>=0 ; i--) {
            minheapify(arr,i);
        }
        System.out.println(Arrays.toString(arr));

    }
    static void minheapify(int[]arr,int idx){
        if (idx>(arr.length/2))return;
        int min=idx;
        if (arr[2*idx]<arr[min]){
            min=2*idx;
        }
        if (2*idx+1<arr.length&&arr[2*idx+1]<arr[min]){
            min=2*idx+1;
        }
        if (min!=idx){
            int temp=arr[idx];
            arr[idx]=arr[min];
            arr[min]=temp;
            minheapify(arr,min);
        }
    }


}

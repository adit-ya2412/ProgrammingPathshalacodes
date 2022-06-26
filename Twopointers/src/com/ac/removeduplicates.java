package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class removeduplicates {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]elements=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        int end=deleteduplicates(arr);
        for (int i = 0; i <end+1 ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    static int deleteduplicates(int[]arr){
        int i=0,j=0;
        while (j<arr.length){
            while (j<arr.length&&arr[j]==arr[i]){
                j++;
            }
            if (j<arr.length){
                swap(arr,i+1,j);
                i++;j++;
            }

        }
        return i;
    }
    static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

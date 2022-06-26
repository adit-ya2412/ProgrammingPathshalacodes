package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class removeelementinplace {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]inputs=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(inputs[i]);
        }
        int val=Integer.parseInt(in.readLine().trim());
        removelemments(arr,val);
        System.out.println(Arrays.toString(arr));
    }
    static void removelemments(int[]arr,int val){
        int i=0,j=arr.length-1;
        while (i<=j){
            while (i<arr.length&&(arr[i]!=val)){
                i++;
            }
            while (j>=0&&(arr[j]==val)){
                j--;
            }
            if (i<j){
                swap(arr,i,j);
                i++;j--;
            }
        }
    }
    static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

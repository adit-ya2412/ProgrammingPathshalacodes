package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class removelementstwice {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]element=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(element[i]);
        }
        int end=removetwice(arr);
        for (int i = 0; i <end ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    static int removetwice(int[]arr){
        if (arr.length<3)return arr.length;
        int i=2,j=2;
        while (j< arr.length){
            if (j< arr.length&&arr[j]!=arr[i-2]){
                arr[i]=arr[j];
                i++;
                j++;
            }else j++;

        }
        return i;

    }
    static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}

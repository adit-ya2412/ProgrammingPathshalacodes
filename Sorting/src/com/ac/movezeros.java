package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class movezeros {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]elements=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        moveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void moveZeros(int[]arr){
        int cnt=0;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i]!=0){
                if (i!=cnt){
                    swap(arr,cnt,i);
                    cnt++;
                }else cnt++;
            }
        }
    }
    static void swap(int[]arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}

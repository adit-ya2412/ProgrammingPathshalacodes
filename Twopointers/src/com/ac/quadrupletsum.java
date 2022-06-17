package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class quadrupletsum {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]elements=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        Arrays.sort(arr);
        int sum=Integer.parseInt(in.readLine().trim());
        printquadruplets(arr,sum);
    }
    static void printquadruplets(int[]arr,int sum){
        for (int i = 0; i < arr.length ; i++) {
            if (i>0&&arr[i]==arr[i-1])continue;
            for (int j = i+1; j < arr.length ; j++) {
                if (j>i+1&&arr[j]==arr[j-1])continue;
                else {
                    int l=j+1;
                    int h= arr.length-1;
                    int fix=sum-arr[i]-arr[j];
                    int cur=0;
                    while (l<h){
                   cur=arr[l]+arr[h];
                   if (cur==fix){
                       System.out.println(arr[i]+","+arr[j]+","+arr[l]+","+arr[h]);
                       if (arr[l]==arr[h])break;
                       int v1=arr[l];
                       int v2=arr[h];
                       while (arr[l]==v1)l++;
                       while (arr[h]==v2)h--;
                   }else if (cur<fix)l++;
                   else {
                       h--;
                   }
                    }
                }
            }
        }
    }
}

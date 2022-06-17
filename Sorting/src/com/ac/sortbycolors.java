package com.ac;

import java.util.Arrays;
import java.util.Scanner;

public class sortbycolors {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
       sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void sortColors(int[]arr){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length ; i++) {
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        int[]freq=new int[max-min+1];
        for (int i = 0; i <arr.length ; i++) {
            freq[arr[i]-min]++;
        }
        for (int i = 1; i < freq.length ; i++) {
            freq[i]+=freq[i-1];
        }
        int[]ans=new int[arr.length];
        for (int i = 0; i <arr.length; i++) {
            ans[freq[arr[i]-min]-1]=arr[i];
            freq[arr[i]-min]--;
        }
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=ans[i];
        }
    }
}

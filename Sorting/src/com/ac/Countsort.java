package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Countsort {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]elements=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        System.out.println(Arrays.toString(CountSort(arr)));
    }
    static int[] CountSort(int[]arr){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length ; i++) {
            min=Math.min(arr[i],min);
            max=Math.max(max,arr[i]);
        }
        int []freq=new int[max-min+1];
        for (int i = 0; i <arr.length ; i++) {
            freq[arr[i]-min]++;
        }
        for (int i = 1; i < freq.length ; i++) {
           freq[i]+=freq[i-1];
        }
        int[]ans=new int[arr.length];
        for (int i = 0; i <arr.length ; i++) {
            ans[freq[arr[i]-min]-1]=arr[i];
            freq[arr[i]-min]--;
        }
        return ans;
    }
}

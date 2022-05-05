package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class repeatedelements {
    public static void main(String[] args)throws IOException {
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(inp.readLine().trim());
        String[]elements=(inp.readLine().trim()).split("\\s+");
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        System.out.println(arr[repeated(arr)]);

    }
    static int repeated(int[]arr){
        int l=0;
        int h=arr.length-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]==mid){
                h=mid-1;
            }else {
                if (arr[mid]==arr[mid+1])return mid;
                l=mid+1;
            }
        }
        return -1;
    }
}

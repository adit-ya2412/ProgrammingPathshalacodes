package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class minimumsizesubarray {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        String[]elements=(in.readLine().trim()).split("\\s+");
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        int t=Integer.parseInt(in.readLine().trim());
        while (t!=0){
            long target=Long.parseLong(in.readLine().trim());
            System.out.println(size(n,arr,target));
            t--;
        }
    }
    static long size(int n,int[]arr,long target){
        long l=0;
        long h=n-1;
        while (l<=h){
            long mid=l+(h-l)/2;
            if (ifpossible(mid,arr,target)){
                if (!ifpossible(mid-1,arr,target))return mid;
                h=mid-1;
            }else {
                l=mid+1;
            }
        }
        return 0;
    }
    static boolean ifpossible(long size,int[]arr,long target){
        if (size<=0)return false;
        long sum=0;
        for (int i = 0; i <size ; i++) {
           sum+=arr[i];
        }
        if (sum>=target)return true;
        for (long i = size; i <arr.length ; i++) {
            sum-=arr[(int) (i-size)];
            sum+=arr[(int) i];
            if (sum>=target)return true;
        }
        return false;
    }
}

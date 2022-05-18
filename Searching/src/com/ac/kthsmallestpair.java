package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class kthsmallestpair {
    public static void main(String[] args)throws IOException {
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(inp.readLine().trim());
        int[]arr=new int[n];
        String[]elements=(inp.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        long k=Integer.parseInt(inp.readLine().trim());
        Arrays.sort(arr);

        System.out.println(searchsmallest(0,arr[n-1]-arr[0],arr,k));
    }
    static long count(int target,int[]arr){
        long cnt=0;
        for (int i = 0; i <arr.length ; i++) {
            long low=i+1;
            long hgh=arr.length-1;
            while (low<=hgh){
                long mid=low+(hgh-low)/2;
                if (arr[(int) mid]-arr[i]>target){
                    hgh=mid-1;
                }else {
                    cnt+=mid-low+1;
                    low=mid+1;
                }
            }
        }
        return cnt;
    }
    static int searchsmallest(int l,int h,int[]arr,long k){
        while (l<=h){
            int mid=l+(h-l)/2;
            if (count(mid,arr)>=k){
                if (count(mid-1,arr)<k)return mid;
                else h=mid-1;
            }else l=mid+1;
        }
        return -1;
    }

}

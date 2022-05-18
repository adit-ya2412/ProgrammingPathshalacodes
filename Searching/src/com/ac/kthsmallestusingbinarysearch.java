package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kthsmallestusingbinarysearch {
    public static void main(String[] args)throws IOException {
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(inp.readLine().trim());
        int[]arr=new int[n];
        String[]elements=(inp.readLine().trim()).split("\\s+");
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <n ; i++) {
            int ele=Integer.parseInt(elements[i]);
            max=Math.max(max,ele);
            min=Math.min(min,ele);
            arr[i]=ele;
        }
        int k=Integer.parseInt(inp.readLine().trim());
        System.out.println(search(arr,min,max,k));

    }
    static int search(int[]arr,int l,int h,int k){
        while (l<=h){
            int mid=l+(h-l)/2;
           int freq=count(arr,mid);
           if (freq>=k){
               int check=count(arr,mid-1);
               if (check<k)return mid;
               else h=mid-1;
           }else l=mid+1;
        }
        return -1;
    }
    static int count(int[]arr,int ele){
        int frqof=0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]<=ele)frqof++;
        }
        return frqof;
    }
}

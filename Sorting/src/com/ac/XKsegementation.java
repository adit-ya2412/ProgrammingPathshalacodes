package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class XKsegementation {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String[]inputs=(in.readLine().trim()).split("\\s+");
        int n=Integer.parseInt(inputs[0]);
        long x=Long.parseLong(inputs[1]);
        long k=Long.parseLong(inputs[2]);
        long[]arr=new long[n];
        String[]elements=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Long.parseLong(elements[i]);
        }
        System.out.println(countpairs(arr,x,k,n));

    }
    static Long countpairs(long[]arr,long x,long k,int n){
        Arrays.sort(arr);
        long ans=0;
        for (int i = 0; i <n ; i++) {
            int ind=binarysearch(arr,i,x,k);
            ans+=(ind-i);
        }
        return ans;
    }
    static int binarysearch(long []arr,int st,long x,long k){
        int l=st;
        int h=arr.length-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if ((arr[mid]/x)-((arr[st]-1)/x)<=k){
                l=mid+1;
            }else if (arr[mid]>k){
                h=mid-1;
            }
        }
        return h;
    }
}

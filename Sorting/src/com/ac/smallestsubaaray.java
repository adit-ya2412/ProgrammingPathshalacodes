package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class smallestsubaaray {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        String[]elements=(in.readLine().trim()).split("\\s+");
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        int k=Integer.parseInt(in.readLine().trim());
        System.out.println(smallestlength(arr,k));

    }
    static int smallestlength(int[]arr,int k){
        int[]prefsum=new int[arr.length];
        prefsum[0]=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            prefsum[i]=prefsum[i-1]+arr[i];
        }
        if(prefsum[prefsum.length-1]<k)return 0;
        int small=search(prefsum,k);
        return small;
    }
    static int search(int[]prefsum,int k) {
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i <prefsum.length; i++) {
            int l = i;
            int h = prefsum.length - 1;
            int sum;
            while (l <= h) {
                int mid = l + (h - l) / 2;
                if (i==0)sum=prefsum[mid];
                else sum=(prefsum[mid]-prefsum[i-1]);
                if (sum>=k){
                    int sum1=0;
                    if (i!=0){
                        sum1=prefsum[mid-1]-prefsum[i-1];
                    }else {
                        if (mid!=0)sum1=prefsum[mid-1];

                    }
                    if (sum1<k){
                        ans=Math.min(ans,mid-i+1);
                        break;
                    }else h=mid-1;
                }else l=mid+1;
            }
        }
        return ans;
    }

}

package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class firstindexof1 {
    public static void main(String[] args)throws IOException {
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(inp.readLine().trim());
        int[]arr=new int[n];
        String[]elements=(inp.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        System.out.println(firstindex(arr,1));

    }
    static int firstindex(int[]arr,int k){
        int l=0;
        int h=arr.length-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (arr[mid]<k){
                l=mid+1;
            }else if (arr[mid]>k){
                h=mid-1;
            }else {
                if (mid!=0&&arr[mid-1]!=k)return mid+1;
                if (mid==0)return mid+1;
                h=mid-1;
            }
        }
        return -1;
    }
}

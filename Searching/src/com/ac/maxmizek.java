package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class maxmizek {
    public static void main(String[] args)throws IOException {
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(inp.readLine().trim());
        String[]elements=(inp.readLine().trim()).split("\\s+");
        int[]a=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=Integer.parseInt(elements[i]);
        }
        int x=Integer.parseInt(inp.readLine().trim());
        System.out.println(maxvalue(a,x));
    }
    static int maxvalue(int[]arr,int x){
        int l=1;
        int h=arr.length;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (ispossible(arr,mid,x)){
                if (!ispossible(arr,mid+1,x))return mid;
                else l=mid+1;//why  cant it be l=m+2;
            }else h=mid-1;
        }
        return -1;
    }
    static boolean ispossible(int[]arr,int m,int x){
        if (m==arr.length+1)return false;
        int sum=0;

        for (int i = 0; i <m ; i++) {
        sum+=arr[i];
        }
        if (sum>x)return false;
        for (int i = m; i <arr.length ; i++) {
            sum-=arr[i-m];
            sum+=arr[i];
            if (sum>x)return false;
        }
return true;
    }
}

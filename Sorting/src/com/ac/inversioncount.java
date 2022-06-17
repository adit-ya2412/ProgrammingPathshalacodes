package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class inversioncount {



    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());
        String[] elements = (in.readLine().trim()).split("\\s+");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(elements[i]);
        }
        long count=invercount(arr, arr.length);
        System.out.println(count);
    }
    static long con=0;
    static long invercount(long[]arr,long n){
        con=0;
        mergesort(arr,0, arr.length-1);
        return con;

    }
    static void mergesort(long[]arr,int st,int end){
        if (st==end)return;
        int m=(st+(end-st)/2);
        mergesort(arr,st,m);
        mergesort(arr,m+1,end);
        merge(arr,st,m,end);
    }
    static void merge(long[]arr,int st,int mid,int end){
        long[]temp=new long[end-st+1];
        int i=st;
        int j=mid+1;
        int k=0;
        while (i<=mid&&j<=end){
            if (arr[i]<=arr[j]){
                temp[k]=arr[i];
                i++;
            }else {
                con+=(mid-i+1);
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        while (i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=end){
            temp[k++]=arr[j++];
        }
        for (int l = 0; l <temp.length ; l++) {
            arr[l+st]=temp[l];
        }
    }


}

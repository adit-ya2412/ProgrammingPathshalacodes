package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class reversepairs {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]elements=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        System.out.println(reversePairs(arr));
    }
    static int count=0;
    static int reversePairs(int[]arr){
        mergesort(arr,0,arr.length-1);
        return count;
    }
    static void mergesort(int[]arr,int st,int end){
        if (st==end)return;
        int m=(st+end)/2;
        mergesort(arr,st,m);
        mergesort(arr,m+1,end);
        merge(arr,st,m,end);

    }
    static void merge(int[]arr,int st,int mid,int end){
        int[]ans=new int[end-st+1];
        int i=st;
        int j=end;
        for (int k = mid+1; k <=end ; k++) {
            int l=st;
            long product;
            product=(long)2*arr[k];
            while (l<=mid&&arr[l]<=product){
                l++;
            }
            count+=mid-l+1;
        }
        int k=0;
        while (i<=mid&&j<=end){
            if (arr[i]<=arr[j]){
                ans[k]=arr[i];
                i++;
            }else {
                ans[k]=arr[j];
                j++;
            }
            k++;
        }
        while (i<=mid){
            ans[k]=arr[i];
            i++;
            k++;
        }
        while (j<=end){
            ans[k]=arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < ans.length ; l++) {
            arr[l+st]=ans[l];
        }
    }
}

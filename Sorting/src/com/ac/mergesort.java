package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class mergesort {

    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        String []ar=(in.readLine().trim()).split("\\s+");
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ar[i]);
        }
        mergesorting(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static int[]mergesorting(int[]arr){
        if (arr.length==1)return new int[]{arr[0]};
        int[]temp1=new int[arr.length/2];
        for (int i = 0; i < arr.length/2 ; i++) {
            temp1[i]=arr[i];
        }
        int[] temp2=new int[arr.length- temp1.length];
        for (int i = (arr.length/2); i < arr.length ; i++) {
            temp2[i-((arr.length/2))]=arr[i];
        }
        int[]arr1=mergesorting(temp1);
        int[]arr2=mergesorting(temp2);
        return merge(arr1,arr2);
    }
    static int[]merge(int[]arr1,int[] arr2){
    int[]as=new int[arr1.length+ arr2.length];
        int k=0,i=0,j=0;
        while (k< as.length){
            if (i< arr1.length&&j< arr2.length){
                if (arr1[i]<=arr2[j]){
                    as[k]=arr1[i];
                    i++;

                }else {
                    as[k]=arr2[j];
                    j++;
                }
                k++;
            }else {
                while (i< arr1.length){
                    as[k]=arr1[i];
                    i++;
                    k++;
                }
                while (j< arr2.length){
                    as[k]=arr2[j];
                    j++;
                    k++;
                }
            }
        }
        return as;
    }
    static void mergesorting(int[]arr,int st,int end){
        if (st==end)return;
        int m=(st+end)/2;
        mergesorting(arr,st,m);
        mergesorting(arr,m+1,end);
        merge(arr,st,m,end);
    }
   static void merge(int[]arr,int s,int m,int e){
        int[]ans=new int[e-s+1];
        int i=s;
        int j=m+1;
        int k=0;

            while (i<=m&&j<=e){
              if (arr[i]<=arr[j]){
                  ans[k]=arr[i];
                  i++;
              }else {
                  ans[k]=arr[j];
                  j++;
              }
              k++;
            }
                while (i<=m){
                    ans[k]=arr[i];
                    i++;
                    k++;
                }
                while (j<=e){
                    ans[k]=arr[j];
                    j++;
                    k++;
                }


       for (int l = 0; l < ans.length ; l++) {
           arr[l+s]=ans[l];
       }
    }
}

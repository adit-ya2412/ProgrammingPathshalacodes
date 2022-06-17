package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Mergeprocess {
    public static void main(String[] args)throws IOException {
         int []arr1={1,2,3,0,0,0};
         int[]arr2={2,5,6};
         merge(arr1, 3, arr2,arr2.length);
        System.out.println(Arrays.toString(arr1));
    }
    static void merge(int[]arr1,int m,int[]arr2,int n){
        int[]ans=new int[m+n];
        int k=0,i=0,j=0;
        while (k< ans.length){
            if (i<m&&j<n){
                int min=Math.min(arr1[i],arr2[j]);
                if (min==arr1[i]){
                    ans[k]=min;
                    i++;
                    k++;
                }else {
                    ans[k]=min;
                    j++;
                    k++;
                }
            }else {
                while (j<n) {
                    ans[k] = arr2[j];
                    j++;
                    k++;
                }
                while (i<m){
                    ans[k]=arr1[i];
                    i++;
                    k++;
                }
            }
        }
        for (int l = 0; l < ans.length ; l++) {
            arr1[l]=ans[l];
        }

    }
}

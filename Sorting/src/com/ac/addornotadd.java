package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class addornotadd {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]inputs=(br.readLine().trim()).split("\\s+");
        int n=Integer.parseInt(inputs[0]);
        long k=Long.parseLong(inputs[1]);
        String[]ele=(br.readLine().trim()).split("\\s+");
        int[]arr=new int[n];

        for (int i = 0; i <n; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        Arrays.sort(arr);
        long[]prefsum=new long[n];
        prefsum[0]=arr[0];
        for (int i = 1; i <n ; i++) {
            prefsum[i]=prefsum[i-1]+arr[i];
        }
        int ans=-1;

        int maxrepeat=0;
        for (int i = 1; i <n ; i++) {
            int indexfound=binarysearch(i,prefsum,k,arr);
            if (i-indexfound+1>ans){
                ans=i-indexfound+1;
                maxrepeat=arr[i];
            }
        }
        System.out.println(ans+" "+maxrepeat);
    }
    static int binarysearch(int st,long[]prefsum,long k,int[]arr){
        int l=0;
        int h=st;
        int result=0;
        long have;
        long required;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (mid==0){
                have=prefsum[st-1];
                required=(st-mid)*arr[st];
            }else {
                have=prefsum[st-1]-prefsum[mid-1];
                required=(st-mid)*arr[st];

            }
            if (have+k>=required){
                result=mid;
                h=mid-1;
            }else {
                l=mid+1;
            }
        }
        return result;
    }
}

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
        long[]arr=new long[n];

        for (int i = 0; i <n; i++) {
            arr[i]=Long.parseLong(ele[i]);
        }
        Arrays.sort(arr);
        long[]prefsum=new long[n];
        prefsum[0]=arr[0];
        for (int i = 1; i <n ; i++) {
            prefsum[i]=prefsum[i-1]+arr[i];
        }
        long ans=-1;

        long maxrepeat=0;
        for (int i = n-1; i >=0 ; i--) {
            int indexfound=binarysearch(i,prefsum,k,arr);
            int tcnt=i-indexfound+1;
            if (tcnt==ans){
                maxrepeat=Math.min(maxrepeat,arr[i]);
            }
            if (tcnt>ans){
                ans=tcnt;
                maxrepeat=arr[i];
            }
        }
        System.out.println(ans+" "+maxrepeat);
    }
    static int binarysearch(int st,long[]prefsum,long k,long[]arr){
        int l=0;
        int h=st;
        int result=0;
        long have;
        long required;
        while (l<=h){
            int mid=l+(h-l)/2;
            int diff=st-mid+1;
            if (mid==0){
                have=prefsum[st];
                required=(diff)*arr[st];
            }else {
                have=prefsum[st]-prefsum[mid-1];
                required=(diff)*arr[st];

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

package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class specialelection {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine().trim());
        while (t!=0){
            int n=Integer.parseInt(in.readLine().trim());
            String[]elements=(in.readLine().trim()).split("\\s+");
            int[]arr=new int[n];
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(elements[i]);
            }
            int[]votes=counnofvotes(arr);
            System.out.println(Arrays.toString(votes));
            t--;
        }

    }
    static int[]counnofvotes(int[]arr) {
        int[] prefsum = new int[arr.length];
        prefsum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefsum[i] = prefsum[i - 1] + arr[i];
        }
        int[]ans=new int[arr.length];
        for (int i = 0; i < arr.length ; i++) {
            if (i==0){
                findright(i,ans,prefsum,arr);
            }else if (i== arr.length-1){
               findleft(i,ans,prefsum,arr);
            }else {
                findright(i,ans,prefsum,arr);
                findleft(i,ans,prefsum,arr);
            }
        }


        for (int i =ans.length-2; i >=0  ; i--) {
            ans[i]+=ans[i+1];
        }

        return ans;

    }
    static void findright(int index,int[]ans,int[]prefsum,int[]arr){
        int l=index+1;
        int h=arr.length-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (prefsum[mid-1]-prefsum[index]<=arr[index]){
                l=mid+1;
            }else {
                h=mid-1;
            }
        }
        ans[h]++;
    }
    static void findleft(int index,int[]ans,int[]prefsum,int[]arr){
       int h=index-1;
       int l=0;
       while (l<=h) {
           int mid = l + (h - l) / 2;
           if (prefsum[index] - prefsum[mid] - arr[index] <= arr[index]) {
               h = mid - 1;
           } else {
               l = mid + 1;
           }
       }
           if (l>0)ans[l-1]--;
       }


}

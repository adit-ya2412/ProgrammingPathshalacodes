package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class distinctrecatangles {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String ele[]=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        int thresharea=Integer.parseInt(in.readLine().trim());
        System.out.println(distinct(arr,thresharea));
    }
    static int distinct(int[]arr,int area){
        int ans=0;
        int l=0;
        int h=arr.length-1;
        while (l<=h){
            if (arr[l]*arr[h]>area){
                h--;
            }else{
                int dist=(h-l+1);
                ans+=(2*dist)-1;
                l++;
            }
        }
        return ans;
    }
}

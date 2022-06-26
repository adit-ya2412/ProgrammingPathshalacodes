package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bitwiseORofsubarrays {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]elements=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        long mask=1l<<31;
        long ans=0;
        for (int i = 31; i >=0 ; i--) {
            int next= arr.length;
            for (int j =arr.length-1 ; j >=0 ; j--) {
                if((arr[j]&mask)>0){
                    next=j;
                }
                ans+=(n-next)*mask;
            }
            mask>>=1;
        }
        System.out.println(ans);
    }
}

package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class maxweightdistribution {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine().trim());
        while (t!=0){
            String[]inputs=(in.readLine().trim()).split("\\s+");
            int n=Integer.parseInt(inputs[0]);
            int k=Integer.parseInt(inputs[1]);
            int[]arr=new int[n];
            String[]elements=(in.readLine().trim()).split("\\s+");
            for (int i = 0; i <n ; i++) {
                arr[i]=Integer.parseInt(elements[i]);
            }
            System.out.println(maxmidiff(arr,n,k));
            t--;
        }
    }
    static int maxmidiff(int[]arr,int n,int k){
        int s=0,f=0;
        int sg=n-k;
        Arrays.sort(arr);
        if (sg>=k){
            for (int i = 0; i <k ; i++) {
                s+=arr[i];
            }
            for (int i = k; i <n ; i++) {
                f+=arr[i];
            }
            return Math.abs(s-f);
        }else {
            for (int i = 0; i <sg ; i++) {
                s+=arr[i];
            }
            for (int i = sg; i <n ; i++) {
                f+=arr[i];
            }
            return Math.abs(s-f);
        }

    }
}

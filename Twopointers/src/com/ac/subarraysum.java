package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class subarraysum {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=(Integer.parseInt(in.readLine().trim()));
        int[]arr=new int[n];
        String[]elements=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        int sum=Integer.parseInt(in.readLine().trim());
        System.out.println(subarrayexists(arr,sum));

    }
    static boolean subarrayexists(int[]arr,int sum){
        int i=0,j=0;
        int curr=arr[i];
        while (j< arr.length){
            if (curr<sum){
                j++;
                if (j< arr.length)curr+=arr[j];
            }else if (curr>sum){
                curr-=arr[i];
                i++;
                if (i>j)j++;
                if (j< arr.length)curr+=arr[j];
            }else {
                return true;
            }
        }
        return false;
    }
}

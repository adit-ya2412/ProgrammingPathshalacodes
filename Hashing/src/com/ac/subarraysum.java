package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class subarraysum {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]ele=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        int sum=Integer.parseInt(in.readLine().trim());
        HashMap<Integer,Integer>map=new HashMap<>();
       int[] prefsum=new int[n];
       prefsum[0]=arr[0];
        for (int i = 1; i <n ; i++) {
            prefsum[i]=prefsum[i-1]+arr[i];
        }
        map.put(0,0);
        for (int i = 0; i <n ; i++) {
            if (map.get(sum-prefsum[i])!=null) System.out.println("subarray exists with sum ="+sum);
            else map.put(prefsum[i],0 );
        }

    }
}

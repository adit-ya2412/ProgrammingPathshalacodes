package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class findingminimumXOR {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]inputs=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(inputs[i]);
        }
        Arrays.sort(arr);
        int ans=Integer.MAX_VALUE;
        for (int i = 0; i <n-1 ; i++) {
            ans=Math.min(ans,arr[i]^arr[i+1]);
        }
        System.out.println(ans);
    }
}

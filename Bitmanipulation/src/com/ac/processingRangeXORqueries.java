package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class processingRangeXORqueries {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]inputs=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(inputs[i]);
        }
        int queries=Integer.parseInt(in.readLine().trim());
        int[][]queriess=new int[queries][2];
        for (int i = 0; i <queries; i++) {
            String[]inp=(in.readLine().trim()).split("\\s+");
            queriess[i][0]=Integer.parseInt(inp[0]);
            queriess[i][1]=Integer.parseInt(inp[1]);
        }

        int[]pref=new int[n];

        pref[0]=arr[0];
        for (int i = 1; i <n ; i++) {
            pref[i]=pref[i-1]^arr[i];
        }
        int st=0,end=0;
        int []ans=new int[queriess.length];
        for (int i = 0; i <queriess.length ; i++) {
            st=queriess[i][0];
            end=queriess[i][1];
            if (st!=0){
                ans[i]=pref[end]^pref[st-1];
            }else {
                ans[i]=pref[end];
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}

package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class longestconsecutivesubsequence {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]ele=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        System.out.println(longestsubsequence(arr,n));
    }
    static int longestsubsequence(int[]arr,int n){
        HashMap<Integer,Integer>map=new HashMap<>();
        int val=0;
        int ls,rs;
        for (int i = 0; i <n ; i++) {
            if (map.get(arr[i])==null){
                ls=map.getOrDefault(arr[i]-1,0);
                rs=map.getOrDefault(arr[i]+1,0);
                val=Math.max(val,1+ls+rs);
                map.put(arr[i],1+ls+rs);
                map.put(arr[i]-ls,map.get(arr[i]));
                map.put(arr[i]+rs,map.get(arr[i]));
            }
        }
        return val;
    }
    static int longestsubsequence2(int[]arr,int n){
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i <n ; i++) {
            map.put(arr[i],0);
        }
        HashMap<Integer,Integer>touched=new HashMap<>();
        int ans=Integer.MIN_VALUE;
        for (int i = 0; i <n ; i++) {
            if (map.getOrDefault(arr[i]-1,-1)==-1) {
                int element = arr[i];
                int len = 0;
                if (touched.get(element) == null) {
                    touched.put(element,1);
                    while (map.get(element) != null) {
                        element++;
                        len++;
                    }
                    ans = Math.max(len, ans);
                }
            }
        }
        return ans;

    }

}

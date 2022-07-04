package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class longeestsubarrayofsum {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]ele=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        int sum=Integer.parseInt(in.readLine().trim());
        int subarraysize=longestsubarray(arr,sum);
        System.out.println(subarraysize);
    }
    static int longestsubarray(int[]arr,int sum){
        int prefsu=0;
        int ans=Integer.MIN_VALUE;
        HashMap<Integer,Integer>maps=new HashMap<>();
        maps.put(0,-1);
        for (int i = 0; i <arr.length ; i++) {
            prefsu+=arr[i];
            if (maps.get(prefsu-sum)!=null){
                ans=Math.max(ans,i-maps.get(prefsu-sum));
            }
            if (maps.get(prefsu)==null){
                maps.put(prefsu,i);
            }
        }
        return ans;
    }
}

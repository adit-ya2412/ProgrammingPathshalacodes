package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class countsubarrayssum {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        int sum=Integer.parseInt(in.readLine().trim());
        String[]ele=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        System.out.println(count(arr,sum));

    }
    static int count(int[]arr,int sum){
        int ans=0;
        int prefix=0;
        HashMap<Integer,Integer>maps=new HashMap<>();
        maps.put(0,1);
        for (int i=0;i< arr.length;i++){
            prefix+=arr[i];
            Integer cnt=maps.get(prefix-sum);
            if (cnt!=null){
                ans+=maps.get(prefix-sum);
            }
            maps.put(prefix,maps.getOrDefault(prefix,0)+1 );
        }
      return ans;
    }
}

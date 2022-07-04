package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class findsubarraysumdivisiblebyK
{
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[]arr=new int[n];
        String[]ele=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        int k=Integer.parseInt(br.readLine().trim());
        System.out.println(count(arr,k));
    }
    static int count(int []arr,int k){
         int sum=0;
         int rem=0;
         int ans=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < arr.length ; i++) {
            sum+=arr[i];
            rem=sum%k;
            if (rem<0)rem+=k;
            if (map.containsKey(rem)){
                ans+=map.get(rem);
                map.put(rem,map.get(rem)+1);
            }else {
                map.put(rem,1);
            }
        }
        return ans;
    }
}

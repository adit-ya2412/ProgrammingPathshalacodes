package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class checkforpair {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]ele=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        int sum=Integer.parseInt(in.readLine().trim());
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i <n ; i++) {
            if (map.get((sum-arr[i]))!=null){
                System.out.println(arr[i]+" "+(sum-arr[i]));
            }else {
                map.put(arr[i],0);
            }
        }
    }
}

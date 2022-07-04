package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class processingqueries {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]ele=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int i = 0; i <n ; i++) {
            map.put(arr[i],0 );
        }
        int q=Integer.parseInt(in.readLine().trim());
        String[]queries=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <q ; i++) {
            int e=Integer.parseInt(queries[i]);
           if (map.get(e)!=null) System.out.println("true");
           else System.out.println("false");
        }
    }
}

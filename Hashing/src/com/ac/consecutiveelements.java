package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;

public class consecutiveelements {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        long[]arr=new long[n];
        String[]elements=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Long.parseLong(elements[i]);
        }
        System.out.println(checkconsecutive(arr));
    }
    static boolean checkconsecutive(long[]arr){
        HashMap<Long,Long>map=new HashMap<>();
        long min=Long.MAX_VALUE;
        for (int i = 0; i < arr.length ; i++) {
            map.put(arr[i],0l);
            min=Math.min(min,arr[i]);
        }
        for (long i = min; i <min+ arr.length ; i++) {
            if (map.get(i)==null)return false;
        }
        return true;
    }
}

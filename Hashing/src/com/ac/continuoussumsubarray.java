package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.InterruptedByTimeoutException;
import java.util.HashMap;

public class continuoussumsubarray {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[]arr=new int[n];
        String[]inpu=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(inpu[i]);
        }
        int k=Integer.parseInt(br.readLine().trim());
        System.out.println(check(arr,k));
    }
    static boolean check(int[]arr,int k){
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int runningsum=0;
        for (int i = 0; i <arr.length ; i++) {
            runningsum+=arr[i];
            if (k!=0)runningsum%=k;
            if (map.containsKey(runningsum)){
                if (i-map.get(runningsum)>1)return true;
            }else map.put(runningsum,i);
        }
        return false;
    }
}

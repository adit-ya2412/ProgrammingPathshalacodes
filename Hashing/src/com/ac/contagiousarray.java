package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class contagiousarray {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[]arr=new int[n];
        String[]inpu=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(inpu[i]);
        }
        System.out.println(maxcount(arr));
    }
    static int maxcount(int[]arr){
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int cnt=0,max=0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==1)cnt+=1;
            else{
                cnt+=-1;
            }
            if (map.containsKey(cnt)){
                max=Math.max(max,i-map.get(cnt));
            }else map.put(cnt,i);
        }
        return max;
    }
}

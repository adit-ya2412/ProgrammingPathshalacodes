package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class numberofboxes {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        HashMap<Integer,Integer>freq=new HashMap<>();
        String[]inputs=(br.readLine().trim()).split("\\s+");
        int a,cnt=1;
        for (int i = 0; i <n ; i++) {
            a=Integer.parseInt(inputs[i]);
            if (freq.containsKey(a)){
                freq.put(a, freq.get(a)+1);
                cnt=Math.max(cnt,freq.get(a));

            }else freq.put(a,1);
        }
        System.out.println(cnt);
    }
}

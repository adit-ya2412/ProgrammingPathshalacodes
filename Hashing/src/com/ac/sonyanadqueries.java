package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class sonyanadqueries {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine().trim());
        HashMap<Long,Long>map=new HashMap<>();
        long numm;
        String[] inpu;
        while (t!=0){
            inpu=(br.readLine().trim()).split("\\s+");
            numm=Long.parseLong(inpu[1]);
            numm=convertdigits(numm);
            if (inpu[0].equals("+")){
                map.put(numm,map.getOrDefault(numm,0l)+1);
            }else if (inpu[0].equals("-")){
                if (map.containsKey(numm)){
                    map.put(numm,map.get(numm)-1);
                }
            }else {
                System.out.println(map.getOrDefault(numm,0l));
            }
          t--;
        }
    }
    static long convertdigits(long n){
        long ans,r,rev=0;
        int cnt=0;
        while (n!=0){
            r=(n%10)%2;
            rev= ((r*(long)Math.pow(10,cnt)+rev));
            n=n/10;
            cnt++;
        }
        return rev;
    }
}

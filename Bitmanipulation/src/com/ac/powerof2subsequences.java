package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class powerof2subsequences {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        String[]inputs=(in.readLine().trim()).split("\\s+");
        ArrayList<Long>li=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            li.add(Long.parseLong(inputs[i]));
        }
        System.out.println(numberofsubsequences(li,n));

    }
    static Long numberofsubsequences(List<Long>A,int n){
        int count=0;
        long num;
        for (int i = 0; i <n ; i++) {
            num=A.get(i);
            if ((num&(num-1))==0)count++;
        }
        long modulo= (long) (Math.pow(10,9)+7);
        return (long)(Math.pow(2,count)-1)%modulo;
    }
}

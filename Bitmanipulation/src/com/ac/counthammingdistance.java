package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class counthammingdistance {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]input=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(input[i]);
        }
        System.out.println(countdistance(arr));
    }
    static long countdistance(int[]arr){
        long mask=1l<<31;
        long count=0;
        for (int i = 31; i >=0 ; i--) {
            int cnt=0;
            for (int j = 0; j <arr.length ; j++) {
                if((arr[j]&mask)>0)cnt++;
            }
            count+=(cnt*(arr.length-cnt));
            mask>>=1;
        }
        return count;
    }
}

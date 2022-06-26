package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Detectingoddoneout {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]inputs=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(inputs[i]);
        }
        System.out.println(findrepeated(arr));
    }
    static long findrepeated(int[]arr){
        long mask=1l<<31;
        long ans=0;
        for (int i = 31; i >=0 ; i--) {
            int cnt=0;
            for (int j = 0; j <arr.length ; j++) {
                if ((arr[j]&mask)>0)cnt++;
            }
            if (cnt%3!=0)ans+=mask;
            mask>>=1;
        }
        return ans;
    }
}

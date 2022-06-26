package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class find2elements {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]ele=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        int overall=0;
        for (int i = 0; i <n ; i++) {
            overall^=arr[i];
        }
        
        long leastsetbit=1;
        while ((overall&leastsetbit)==0){
            leastsetbit<<=1;
        }
        int value1=0,value2=0;
        for (int i = 0; i <n ; i++) {
            if ((arr[i]&leastsetbit)>0){
                value1^=arr[i];}
//            }else {
//                value2^=arr[i];
//            }
        }
        value2=value1^overall;
        System.out.println(value1+" , "+value2);
    }
}

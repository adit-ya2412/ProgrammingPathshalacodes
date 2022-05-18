package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class smallestgoodbase {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine().trim());
        while (t!=0){
            long n=Long.parseLong(in.readLine().trim());
            System.out.println(minibase2(n));
            t--;
        }
//        System.out.println(minibase(13));
    }
    static String minibase(long num){
        for (int i = 63; i >=1 ; i--) {
            long l=2;
            long h=num-1;
            while (l<=h){
                long mid=l+(h-l)/2;
                long s=0;
                long x=1;
                int flag=0;
                for (int j = 0; j <=i ; j++) {
                    s+=x;
                    if (s>=num)break;
                    if (j<i&&((num-s)/x)<mid){
                      flag=1;
                      break;
                    }
                    if (j<i)x*=mid;
                }
                if (s>num||flag==1)h=mid-1;
                else if (s<num)l=mid+1;
                else if (s==num)return ""+mid;

            }
        }
        return ")";
    }
    static long minibase2(long num){
        for (int i = 63; i >=1 ; i--) {
            long l=2;
            long h=num-1;
            while (l<=h){
                long mid=l+(h-l)/2;
                long s=0;
                long x=1;
                int flag=0;
                for (int j = 0; j <=i ; j++) {
                    s+=x;
                    if (s>=num)break;
                    if (j<i&&((num-s)/x)<mid){
                        flag=1;
                        break;
                    }
                    if (j<i)x*=mid;
                }
                if (s>num||flag==1)h=mid-1;
                else if (s<num)l=mid+1;
                else if (s==num)return mid;

            }
        }
        return 0;
    }
}

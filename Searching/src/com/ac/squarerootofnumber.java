package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class squarerootofnumber {
    public static void main(String[] args)throws IOException {
        BufferedReader inp =new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(inp.readLine().trim());
        while (t!=0){

            int n=Integer.parseInt(inp.readLine().trim());
            System.out.println(sqrt(n));
            t--;
        }
    }
//    static int sqrt(int n){
//        int l=1;
//        int h=n;
//        while (l<=h){
//            int mid=l+(h-l)/2;
//            if (mid*mid>n){
//                h=mid-1;
//            }else if (mid*mid<n){
//                l=mid+1;
//            }else return mid;
//        }
//        return h;
//    }
    static long sqrt(int n){
        long l=1;
        long h=n;
        while (l<=h){
            long mid=l+(h-l)/2;
            if (mid*mid>n){
                h=mid-1;
            }else {
                if ((mid+1)*(mid+1)>n)return mid;
                l=mid+1;
            }
        }
        return 0;
    }
}

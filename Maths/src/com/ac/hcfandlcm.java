package com.ac;

import java.util.Scanner;

public class hcfandlcm {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong();
        long b=sc.nextLong();
        System.out.print(gcd(a,b)+" ");
        System.out.print(lcm(a,b));
    }
    static long gcd(long a,long b){
        long min=Math.min(a,b);
        long max=Math.max(a,b);
        while(min!=0){
            if(max%min==0){
                return min;
            }else{
                long temp=min;
                min=max%min;
                max=temp;
            }
        }
        return 1;
    }
    static long lcm(long a,long b){
        long mult=a*b;
        return mult/gcd(a,b);
    }
}

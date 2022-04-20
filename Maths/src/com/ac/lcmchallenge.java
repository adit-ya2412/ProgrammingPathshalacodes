package com.ac;

import java.util.Scanner;

public class lcmchallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
             long n=sc.nextInt();
            System.out.println(maxlcm(7));
            t--;
        }
    }
    static long maxlcm(long n){
        if (n<=2)return n;
        if(n%2!=0){
         return (n)*(n-1)*(n-2);
        }else {
            if (n%3==0){
                return (n-1)*(n-2)*(n-3);
            }else {
                return (n)*(n-1)*(n-3);
            }
        }
    }
//    static long lcm(long a,long b){
//        if ()
//        return (a*b)/gcd(a, b);
//    }
    static long gcd(long a,long b){
        long min=Math.min(a, b);
        long max=Math.max(a, b);
        if (min<=0)return max;
        while (min!=0){
            if (max%min==0)return min;
            else {
                long temp=max%min;
                max=min;
                min=temp;
            }
        }
        return 1;
    }
}

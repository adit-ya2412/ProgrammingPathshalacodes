package com.ac;

import java.util.Scanner;

public class theratingdilemma {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t!=0){
            long s=sc.nextLong();
            System.out.println(maxproduct(s));
            t--;
        }
    }
    static long maxproduct(long sum){
        long x=sum+1;
        return -x;
    }
}

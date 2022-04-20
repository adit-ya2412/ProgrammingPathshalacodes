package com.ac;

import java.util.Scanner;

public class gcdxor {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t!=0){
            int n=sc.nextInt();
            int[]arr=new int[n];
            for (int i = 0; i <n ; i++) {
                arr[i]=sc.nextInt();
            }
            System.out.println(calculate(arr,n));
            t--;
        }
    }
    static long gcd(long a,long b){
        long min=Math.min(a,b);
        long max=Math.max(a,b);
        while (min!=0){
            if (max%min==0){
                return min;
            }else {
                long temp=max%min;
                max=min;
                min=temp;
            }
        }
        return 1;
    }
    static long calculate(int[]arr,int n){
        if (n==1)return 0;
        if (n==2) return gcd(arr[0],arr[1]);
        long g=gcd(arr[0],arr[1]);
        for (int i = 2; i <n ; i++) {
            g=gcd(g,arr[i]);
        }
        if (g==1)return 1;
        else return 0;
    }
}

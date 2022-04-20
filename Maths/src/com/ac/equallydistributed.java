package com.ac;

import java.util.Scanner;

public class equallydistributed {
    public static void main(String[] args) {
        //System.out.println(gcd(2,0));
//        int[]arr={1,1,2,2,3,3,3};
//        System.out.println(check(arr,arr.length));
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t!=0){
            int n=sc.nextInt();
            int[]arr=new int[n];
            for (int i = 0; i <n ; i++) {
                arr[i]=sc.nextInt();
            }
            System.out.println(check(arr,n));
            t--;
        }
    }
    static boolean check(int[]arr,int n){
        int[]freq=new int[10001];
        for (int i = 0; i <n ; i++) {
            freq[arr[i]]+=1;
        }
        long gcd1=0;
        for (int i = 0; i <1001 ; i++) {
            gcd1=gcd(gcd1,freq[i]);
        }
        if (gcd1>=2)return true;
        return false;
    }
    static long gcd(long a,long b){
        long min=Math.min(a, b);
        long max=Math.max(a, b);
        if (min==0)return max;
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

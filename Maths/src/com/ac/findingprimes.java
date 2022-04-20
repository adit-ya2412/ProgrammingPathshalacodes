package com.ac;

import java.util.Scanner;

public class findingprimes {
    public static void main(String[] args) {
      int n=1000000+1;
      int[]arr=sieve(n);
      int[]counts=count(arr);
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t!=0){
            int num=sc.nextInt();
            System.out.println(noofprime(counts,num));
            t--;
        }
    }
    static int[] sieve(int n){
        int []arr=new int[n+1];
        for (int i = 0; i <n ; i++) {
            arr[i]=1;
        }
        for (int i = 2; i <Math.sqrt(n) ; i++) {
            if (arr[i]==1){
                for (int j = i; j*i <n ; j++) {
                    arr[i*j]=0;
                }
            }
        }
        return arr;

    }
    static int[] count(int[]arr){
        int[]counts=new int[arr.length];
        counts[0]=0;
        counts[1]=0;
        for (int i = 2; i <arr.length ; i++) {
            if (arr[i]==1){
                counts[i]=counts[i-1]+1;
            }else counts[i]=counts[i-1];
        }
        return counts;
    }
    static int noofprime(int[]counts,int n){
        int r=counts[n];
        int l=counts[n/2];
        return r-l;
    }
}

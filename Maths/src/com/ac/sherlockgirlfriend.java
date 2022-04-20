package com.ac;

import java.util.Scanner;

public class sherlockgirlfriend {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        printcolors(n);
    }
    static void printcolors(int n){
        int[]primes=createsieve(n);
        if (n<3) System.out.println(1);
        else System.out.println(2);
        for (int i = 2; i <primes.length ; i++) {
              if (primes[i]==1) System.out.println(1);
              else System.out.println(2);
        }
    }
    static int[] createsieve(int n){
        int t=n+2;
        int[]primes=new int[t];
        for (int i = 2; i <t ; i++) {
         primes[i]=1;
        }
        for (int i = 2; i*i <t ; i++) {
           if (primes[i]==1){
               for (int j = i; j*i <t ; j++) {
                   primes[i*j]=0;
               }
           }
        }
        return primes;
    }
}

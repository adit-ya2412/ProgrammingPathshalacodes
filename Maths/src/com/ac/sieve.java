package com.ac;

public class sieve {
    public static void main(String[] args) {
        printprime(10);
    }
    static void printprime(int n){
        int[]primes=new int[n+1];
        for (int i = 2; i <=n ; i++) {
             primes[i]=1;
        }
        for (int i = 2; i*i <=n ; i++) {
            if (primes[i]==1){
                for (int j = i; i* j <=n ; j++) {
                      primes[i*j]=0;
                }
            }
        }
        for (int i = 1; i <primes.length ; i++) {
            if (primes[i]==1) System.out.println(i);
        }
    }
}

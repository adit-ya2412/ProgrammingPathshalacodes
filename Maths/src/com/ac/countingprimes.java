package com.ac;

import java.util.Scanner;

public class countingprimes {
    public static void main(String[] args) {
      int n=1000000+1;
      long[]sieve=new long[n];
      long[] primescount=new long[n];
      generatesiev(sieve,primescount);
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t!=0){
            int num=sc.nextInt();
            System.out.println(primescount[num]);
            t--;
        }

    }
    static void generatesiev(long[]sieve,long[]primescount) {
        for (int i = 2; i < sieve.length; i++) {
            sieve[i] = 1;
        }
        for (int i = 2; i <= Math.sqrt(sieve.length); i++) {

            if (sieve[i] == 1) {
                for (int j = i; j * i < sieve.length; j++) {
                    if (sieve[i * j] == 1) {
                        sieve[i * j] = 0;
                    }
                }
            }
        }
        primescount[1] = 0;
        for (int i = 2; i < primescount.length; i++) {

            primescount[i] = primescount[i - 1] + sieve[i];

        }
    }
//    static long primesinrange(int n){
//        if (n==0||n==1){
//            return 0;
//        }
//        long[]primes=new long[n+1];
//        for (int i = 2; i <=n ; i++) {
//            primes[i]=1;
//        }
//        long count=0;
//        long[]primesum=new long[n+1];
//        primesum[0]=0;
//        primesum[1]=0;
//        for (int i = 2; i<=Math.sqrt(n) ; i++) {
//            primesum[i]=primesum[i-1]+primes[i];
//            if (primes[i]==1){
//                for (int j = i; j*i <=n ; j++) {
//                    if (primes[i*j]==1){
//                        primes[i*j]=0;
//                    }
//                }
//            }
//        }
//
//        return count;
//    }
}

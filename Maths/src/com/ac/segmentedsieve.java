package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class segmentedsieve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            List<Integer> primes = primerange(r);
            System.out.println(sieveofgivennumbers(l, r, primes));
            t--;

         }
    }
    static List primerange(long r){
        int[]primes=new int[(int)Math.sqrt(r)+1];
        for (int i = 2; i <primes.length ; i++) {
            primes[i]=1;
        }
        List<Integer>prime=new ArrayList<>();
        for (int i = 2; i<Math.sqrt(primes.length) ; i++) {
            if (primes[i]==1){

                for (int j = i; j*i <primes.length ; j++) {
                    primes[i*j]=0;
                }
            }
        }
        for (int i=2;i<primes.length;i++){
            if (primes[i]==1)prime.add(i);
        }
       return prime;

    }
    static long sieveofgivennumbers(long l,long r,List<Integer>primes){
        long[]arr=new long[(int)(r-l+1)];
        for (int i = 0; i <primes.size() ; i++) {
            double f=Math.ceil((l*1.0)/primes.get(i));
            f=Math.max(f,2);
            while (f*primes.get(i)<=r){
                arr[(int)(f*primes.get(i)-l)]=-1;
                f++;
            }
        }
        long ans=1;
        long mod=(long)Math.pow(10,9)+7;
        for (long i =l; i <=r ; i++) {
            if (arr[(int)(i-l)]==0){
                ans=((ans%mod)*(i%mod))%mod;
            }
        }
        return (ans%mod);
    }

}

package com.ac;

import java.util.Scanner;

public class primepermutation {
    public static void main(String[] args) {
        int[]arr=generatesiev(100);
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t!=0){
            int n=sc.nextInt();
            System.out.println(permuatations(arr,n));
            t--;
        }
    }
    static long permuatations(int[]arr, int n){
        int primes=arr[n];
        int noprimes=n-primes;
        long mod=(long)Math.pow(10,9)+7;
        long primepermu=1;
        long  nonprimepermu=1;
        long ans;
        for (int i = primes; i >0 ; i--) {
            primepermu=((primepermu%mod)*(i%mod))%mod;
        }
        for (int i = noprimes; i >0 ; i--) {
            nonprimepermu=((nonprimepermu%mod)*(i%mod))%mod;
        }
        ans=((primepermu%mod)*(nonprimepermu%mod))%mod;
        return ans;
    }
    static int[] generatesiev(int n){
        int []ans=new int[n+1];
        for (int i = 2; i <=n ; i++) {
            ans[i]=1;
        }
        for (int i = 2; i*i <=n ; i++) {
            if (ans[i]==1){
                for (int j = i; j*i <=n ; j++) {
                    ans[j*i]=0;
                }
            }
        }
        int[]counts=new int[ans.length];
        counts[0]=0;
        counts[1]=0;
        for (int i = 2; i <counts.length ; i++) {
            if (ans[i]==1){
                counts[i]=counts[i-1]+1;
            }else {
                counts[i]=counts[i-1];
            }
        }
        return counts;
    }
}

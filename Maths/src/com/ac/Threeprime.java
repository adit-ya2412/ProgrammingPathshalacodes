package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Threeprime {
    public static void main(String[] args) throws IOException {
       int n=10000001;
       long[]primes=new long[n];
       primes=generatesiev(primes);

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t!=0){

            int size=Integer.parseInt(br.readLine());
            int[]arr=new int[size];
            String[] strNums;

            strNums = br.readLine().split(" ");
            for (int i = 0; i <size ; i++) {

                arr[i]=Integer.parseInt(strNums[i]);
            }
            System.out.println(sumofthree(primes,arr));
            t--;
        }
    }

    static long[] generatesiev(long[] n) {
        for (int i = 2; i < n.length; i++) {
            n[i] = 1;
        }
        for (int i = 2; i * i < n.length; i++) {
            if (n[i] == 1) {
                for (int j = i; j * i < n.length; j++) {
                    n[i * j] = 0;
                }
            }
        }
        return n;
    }
    static long sumofthree(long[]n,int[]arr){
        long sum=0;
        for (int i = 0; i <arr.length ; i++) {
            long sqrt=(long) Math.sqrt(arr[i]);
            if (sqrt*sqrt==arr[i]&&n[(int)sqrt]==1){
                sum+=arr[i];
            }
        }
        return sum;
    }
}

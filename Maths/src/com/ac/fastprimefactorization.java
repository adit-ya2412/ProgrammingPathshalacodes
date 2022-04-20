package com.ac;

import java.util.ArrayList;
import java.util.List;

public class fastprimefactorization {
    public static void main(String[] args) {
        int[]nums={22,456,234,988,711};
        printprimefactors(nums);
    }
    static void printprimefactors(int[]nums){
        for (int i = 0; i <nums.length ; i++) {
            int[]spf=primenumbers(nums[i]);
            List<Integer>ans=new ArrayList<>();
              int n1=nums[i];
            while (spf[n1]!=-1){
                ans.add(spf[n1]);
                n1=n1/(spf[n1]);
            }
            if (n1!=0)ans.add(n1);
            System.out.println(ans);
        }
    }

    static int[] primenumbers(int n) {
        int[] primes = new int[n + 1];
        int[] spf = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            primes[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            spf[i] = -1;
        }
        for (int i = 2; i * i <= n; i++) {
            if (primes[i] == 1) {
                for (int j = i; i * j <= n; j++) {
                    if (primes[i * j] == 1) {
                        spf[i * j] = i;
                        primes[i * j] = 0;
                    }
                }
            }
        }
        return spf;
    }
}

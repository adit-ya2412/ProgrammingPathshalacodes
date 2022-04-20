package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class properdivisor {
    public static void main(String[] args) {
       int[]primes=new int[10001];
       List<Integer>prime =generateprimes(primes);
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t!=0){
            int n=sc.nextInt();
            System.out.println(sumofdivisors(n,prime));
            t--;
        }

    }
    static long sumofdivisors(long n,List<Integer>primes) {
            long sum = 1;
            long num=n;
            for (int i = 0; i < primes.size(); i++) {
                if (primes.get(i) * primes.get(i) > num)break;
                if (num%primes.get(i)==0){
                    int count=0;
                    while (num%primes.get(i)==0){
                        num=num/primes.get(i);
                        count++;
                    }
                    long sumprimes=0;
                    for (int j =count; j >=0 ; j--) {
                        sumprimes+=Math.pow(primes.get(i),j);
                    }
                    sum*=sumprimes;
                }
            }
            if (num!=1){
                sum*=num+1;
        }
            return sum-n;
    }

    static List generateprimes(int[]pr){
        for (int i = 2; i <pr.length ; i++) {
            pr[i]=1;
        }
        for (int i = 2; i*i <pr.length ; i++) {
            if (pr[i]==1){
                for (int j = i; j*i <pr.length ; j++) {
                    pr[i*j]=0;
                }
            }
        }
        List<Integer>ans=new ArrayList<>();
        for (int i = 0; i <pr.length ; i++) {
            if (pr[i]==1)ans.add(i);
        }
        return ans;
    }
}

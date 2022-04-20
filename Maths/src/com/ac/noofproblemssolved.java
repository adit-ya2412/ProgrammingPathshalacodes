package com.ac;

import java.util.Scanner;

public class noofproblemssolved {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t!=0){
            long n= sc.nextLong();
            long a= sc.nextLong();
            long b=sc.nextLong();
            long k=sc.nextLong();
            System.out.println(decision(n,a,b,k));
            t--;
        }
    }
    static String decision(long n,long a,long b,long k){
        long solvedbybob=n/a;
        long solvedbyalice=n/b;
        long solvedbyboth=n/(lcm(a,b));
        long total=solvedbybob+solvedbyalice-(2*solvedbyboth);
        if (total>=k)return "Win";
        else return "Lose";

    }
    static long gcd(long a,long b){
        long min=Math.min(a,b);
        long max=Math.max(a,b);
        while(min!=0){
            if(max%min==0){
                return min;
            }else{
                long temp=min;
                min=max%min;
                max=temp;
            }
        }
        return 1;
    }
    static long lcm(long a,long b){
        long mult=a*b;
        return mult/gcd(a,b);
    }
}

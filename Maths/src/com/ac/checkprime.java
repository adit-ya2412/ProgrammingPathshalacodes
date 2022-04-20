package com.ac;

public class checkprime {
    public static void main(String[] args) {
        System.out.println(check(6));
        printprime(10);
    }
    static boolean check(int n){
        int s=(int)Math.sqrt(n);
        int count=0;
        for (int i = 2; i <=s ; i++) {
            if (n%i==0)count++;
        }
        if (count==0)return true;
        else return false;
    }
    static void printprime(int n){
        for (int i = 2; i <=n ; i++) {
            int count=0;
            for (int j = 2; j *j<=i ; j++) {
                   if (i%j==0)count++;
            }
            if (count==0) System.out.println(i);
        }
    }
}

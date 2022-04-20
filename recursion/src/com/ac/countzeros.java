package com.ac;

public class countzeros {
    public static void main(String[] args) {
        System.out.println(count(10000000));
    }
    static int count(int n){
        return help(n,0);
    }
    static int help(int n,int c){
        if (n==0){
            return c;
        }
        int rem=n%10;
        if (rem==0){
            return help(n/10,c+1);
        }else {
            return help(n/10,c);
        }
    }
}

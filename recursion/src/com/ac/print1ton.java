package com.ac;

public class print1ton {
    public static void main(String[] args) {
        print(5);
        //rprint(5);
    }
    static void print(int n){
        if (n<1)return;
        print(n-1);
        System.out.println(n);
    }
    static void rprint(int n){
        if (n==0)return;
        System.out.println(n);
        rprint(n-1);
    }
}

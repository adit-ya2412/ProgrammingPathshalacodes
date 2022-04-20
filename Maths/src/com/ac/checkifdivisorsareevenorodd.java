package com.ac;

public class checkifdivisorsareevenorodd {
    public static void main(String[] args) {
        System.out.println(check(16));
    }
    static boolean check(int n){
        int sq=(int) Math.sqrt(n);
        return (sq*sq==n);
    }
}

package com.ac;

public class Generateallfacotrs {
    public static void main(String[] args) {
        factors(16);
    }
    static void factors(int n){
        for (int i = 1; i <=Math.sqrt(n) ; i++) {
            if (n%i==0){
                if (i*i==n) System.out.println(i);
                else{
                    System.out.println(i);
                    System.out.println(n/i);
                }
            }
        }
    }
}

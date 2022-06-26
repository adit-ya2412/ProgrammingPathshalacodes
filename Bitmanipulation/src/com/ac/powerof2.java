package com.ac;

import java.util.Scanner;

public class powerof2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if (n<=0) System.out.println("false");
        if ((n&n-1)==0) System.out.println("true");
        else System.out.println("false");
    }
}

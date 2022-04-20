package com.ac;

import java.util.Scanner;

public class complementofnumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        long powerof2s = 2, temp = num;

        while(temp>>1!=0) {
            temp >>= 1;
            powerof2s <<= 1;
        }
        System.out.println(powerof2s - num - 1);
    }
}

package com.ac;

import java.util.Scanner;

public class findingshoes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t!=0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            System.out.println(noofshoes(n,m));
            t--;
        }
    }
    static int noofshoes(int n,int m){
        int right=n;

        if (m>=n){
             return right;
        }else {
             return 2*n-m;
        }

    }
}

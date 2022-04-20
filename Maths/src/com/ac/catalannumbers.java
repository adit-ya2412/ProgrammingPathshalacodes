package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class catalannumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            int n = sc.nextInt();
            if (n % 2 != 0) System.out.println("-1");
            else {
                System.out.println(catalamatrix(n / 2));
            }
            t--;
        }
    }

    static long catalamatrix(int n){
        long[]cat=new long[n+1];
        cat[0]=1;
        cat[1]=1;
        long mod=(long) Math.pow(10,9)+7;
        for (int i = 2; i <=n ; i++) {
            cat[i]=0;
            for (int j = 0; j <=i-1 ; j++) {
                cat[i]=((cat[i]%mod)+(cat[j]%mod)*(cat[i-1-j]%mod))%mod;
            }
        }
        return cat[n]%mod;
    }
}

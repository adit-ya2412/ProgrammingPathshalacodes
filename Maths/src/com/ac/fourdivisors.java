package com.ac;

import java.util.Scanner;

public class fourdivisors {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t!=0){
            int n=sc.nextInt();
            int[]arr=new int[n];
            for (int i = 0; i <n ; i++) {
                arr[i]=sc.nextInt();
            }
            System.out.println(sum(arr,n));
            t--;
        }
    }

    static int sum(int[] arr, int n) {
        int s = 0;
        for (int i = 0; i < n; i++) {
            s += factors(arr[i]);
        }
        return s;
    }

    static int factors(int n) {
        int s = (int) Math.sqrt(n);
        if (s * s == n) return 0;
        else {
            int c = 0;
            int su = 0;
            for (int i = 1; i <= s; i++) {
                if (n % i == 0) {
                    su = su + i;
                    su = su + n / i;
                    c = c + 2;
                    if (c > 4) return 0;
                }
            }
                if (c == 4) return su;
                else return 0;
        }
    }
}

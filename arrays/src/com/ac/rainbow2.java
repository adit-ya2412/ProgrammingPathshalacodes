package com.ac;
import java.util.*;
public class rainbow2 {
    public static void main(String[] args) {
       test();
    }

    static void test() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int j = 0; j < t; j++) {
            int n = sc.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int c = 0;
            for (int i = 0; i < n / 2; i++) {
                if (a[i] != a[n - i - 1]) {
                    c = 1;
                    break;
                } else if (a[0] != 1) {
                    c = 1;
                } else if (a[n / 2] != 7) {
                    c = 1;
                } else if (a[i + 1] != a[i] + 1 && a[i + 1] != a[i]) {
                    c = 1;
                }
            }


            if (c == 1)
                System.out.println("no");
            else
                System.out.println("yes");
        }
    }
}


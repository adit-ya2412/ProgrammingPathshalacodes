package com.ac;

public class fastexponentiation {
    public static void main(String[] args) {
        System.out.println(exponentiation(2,2));
    }
    static double exponentiation(double n,int k) {
        double s;
        if (k == 0) {
            return 1;
        } else {
            s = exponentiation(n, Math.abs(k / 2));
        }
        if (k < 0) {
            if (Math.abs(k) % 2 == 0) {
                return 1 / (s * s);
            } else {
                return 1 / (s * s * n);
            }
        } else {
            if (Math.abs(k) % 2 == 0) {
                return s * s;
            } else {
                return s * s * n;
            }
        }
    }
}

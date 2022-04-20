package com.ac;

public class GCD {
    public static void main(String[] args) {
        // System.out.println(commonmultiple(13,12));
       // System.out.println(commonmultipledivisionmethod(5, 25));
        int[]arr={9,3,12,15,21};
        System.out.println(arraygcd(arr));
    }

    static int commonmultiple(int n, int m) {
        int cm = 1;
        if (n <= m) {
            for (int i = 2; i <= n; i++) {
                if ((n % i) == 0 && (m % i) == 0) {
                    if (i > cm) cm = i;
                }
            }
        } else {
            for (int i = 2; i <= m; i++) {
                if (n % i == 0 && m % i == 0) {
                    if (i > cm) cm = i;
                }
            }
        }
        return cm;
    }

    static int commonmultipledivisionmethod(int n, int m) {
        if (n == 0) {
            return 1;
        } else if (m == 0) return 1;
        int gcd = 1;
        if (n <= m) {
            int remainder = 1;
            int divisor = n;

            int dividend = m;
            while (remainder != 0) {
                if (dividend % divisor == 0) {
                    gcd = divisor;
                    return gcd;
                } else {
                    remainder = dividend % divisor;
                    dividend = divisor;
                    divisor = remainder;
                }
            }
        } else {
            int remainder = 1;
            int divisor = m;
            int dividend = n;
            while (remainder != 0) {
                if (dividend % divisor == 0) {
                    gcd = divisor;
                    return gcd;
                } else {
                    remainder = dividend % divisor;
                    dividend = divisor;
                    divisor = remainder;
                }
            }
        }
        return gcd;
    }

    static int arraygcd(int[] arr) {
        if (arr.length > 2) {
          int gcdofprevtwo=gcdoftwo(arr[0],arr[1]);
            for (int i = 2; i <arr.length ; i++) {
                gcdofprevtwo=gcdoftwo(gcdofprevtwo,arr[i]);
            }
            return gcdofprevtwo;
        }else {
            return gcdoftwo(arr[0],arr[1]);
        }

    }

    static int gcdoftwo(int n, int m) {
        if (n==0||m==0)return Math.max(n,m);
        int gcd = 1;
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        while (min != 0) {
            if (max % min == 0) {
                gcd = min;
                break;
            } else {
                int temp = max % min;
                max = min;
                min = temp;
            }
        }
        return gcd;
    }
}

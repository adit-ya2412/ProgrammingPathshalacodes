package com.ac;

import java.util.Scanner;

public class codeforcesassignment1M1 {
        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            long p=sc.nextLong();
            long q=sc.nextLong();
            long r= sc.nextLong();
            long[] arr = new long[n];
            for(int i = 0; i < n; i++)
            {
                arr[i] = sc.nextLong();
            }
            long[] prep = new long[n];
            prep[0] = p*arr[0];
            for(int i = 1; i<n; i++)
            {
                prep[i] = Math.max(prep[i-1],p*arr[i]);
            }
            long[] prer= new long[n];
            prer[n-1] = r*arr[n-1];
            for(int i = n-2; i>=0; i--)
            {
                prer[i] = Math.max(prer[i+1],r*arr[i]);
            }
            long ans = prep[0] + prer[0] + (q*arr[0]);
            for(int i = 1; i<n; i++)
            {
                ans = Math.max(ans,(prep[i] + prer[i] + (q*arr[i])));
            }
            System.out.print(ans);
            sc.close();
        }
    }


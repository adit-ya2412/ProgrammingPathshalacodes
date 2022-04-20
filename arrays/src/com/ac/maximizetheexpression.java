package com.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class maximizetheexpression {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long p=sc.nextLong();
        long q=sc.nextLong();
        long r= sc.nextLong();
       long[]arr=new long[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextLong();
        }
        System.out.println(max(arr,p,q,r));
        //answer1(n,p,q,r);
    }
    static long max(long[]arr,long p,long q,long r) {
        List<Long> prem = prefixmpax(arr, p);
        int n=arr.length;
        long[] sufim = suffimax(arr, r);
        long mid;
        long ans = Long.MIN_VALUE;
        //int[]ans1=new int[3];
        for (int i = 0; i <n; i++) {
            mid = q * arr[i];
            long first = prem.get(i);
            long last = sufim[i];
            if ((mid + first + last) > ans) {
                ans = (mid + first + last);
            }
        }
        return ans;
    }
    static List<Long> prefixmpax(long[]arr,long p){
        List<Long>ls=new ArrayList<>();
        ls.add(arr[0]*p);
        for (int i = 1; i <arr.length ; i++) {
            ls.add(Math.max((p*ls.get(i-1)),p*arr[i]));
        }
        return ls;
    }
    static long[] suffimax(long[]arr,long r){
        long[]ans=new long[arr.length];
        ans[arr.length-1]=r*arr[arr.length-1];
        for (int i = arr.length-2; i >= 0; i--) {
            ans[i]=Math.max((ans[i+1]),(r*arr[i]));
        }
        return ans;
    }
    static void answer1(int n,long p,long q,long r){
        Scanner sc=new Scanner(System.in);
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


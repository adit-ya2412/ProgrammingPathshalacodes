package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class commondivisiors {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
        FastReader s = new FastReader();
        int t=s.nextInt();
        while (t!=0){
            long p=s.nextLong();
            long q=s.nextLong();
            System.out.println(common(p,q));
            t--;
        }
    }
    static long gcd(long p,long q){
        long min=Math.min(p,q);
        long max=Math.max(p,q);
        while (min!=0){
            if (max%min==0)return min;
            else {
                long r=max%min;
                max=min;
                min=r;
            }
        }
        return 1;
    }
    static long common(long p,long q){
        long hcf=gcd(p,q);
        long count=0;
        for (int i = 1; i <=Math.sqrt(hcf) ; i++) {
            if (hcf%i==0){
            if (i==(hcf/i))count++;
            else {
                count+=2;
            }
            }
        }
        return count;
    }
}

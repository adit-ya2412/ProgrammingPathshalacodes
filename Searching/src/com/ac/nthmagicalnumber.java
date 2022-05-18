package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nthmagicalnumber {
    public static void main(String[] args)throws IOException {
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(inp.readLine().trim());
        while (t!=0){
            String[]inpu=(inp.readLine().trim()).split("\\s+");
            long n=Integer.parseInt(inpu[0]);
            long a=Integer.parseInt(inpu[1]);
            long b=Integer.parseInt(inpu[2]);
            long l=Math.min(a,b);
            long h=n*l;
            long hcf=gcd(a,b);
            long lcm=(a*b)/hcf;
            System.out.println(search(l,h,n,a,b,lcm));
            t--;
        }
    }
    static long search(long l,long h,long n,long a,long b,long lcm){
        long modulo= (long) (Math.pow(10,9)+7);
       while (l<=h) {
           long mid=l+(h-l)/2;
           long postiton=count(mid,a,b,lcm);
           if (postiton>=n){
               if (count(mid-1,a,b,lcm)<n)return mid%modulo;
               else h=mid-1;
           }else l=mid+1;
       }
       return 0;
    }
    static long count(long mid,long a,long b,long lcm){
        long dividedbya=mid/a;
        long dividedbyb=mid/b;
        long dividedbyboth=mid/lcm;
        return dividedbya+dividedbyb-dividedbyboth;

    }
    static long gcd(long a,long b){
        if (a==0||b==0)return 1;
        long min=Math.min(a,b);
        long max=Math.max(a,b);

        while (min!=0){
            if (max%min==0){
                return min;
            }else {
                long temp=max%min;
                max=min;
                min=temp;
            }
        }
        return 0;
    }
}

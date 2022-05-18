package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class nthuglynumber {
    public static void main(String[] args)throws IOException {
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(inp.readLine().trim());
        while (t!=0){
            String[]inpu=(inp.readLine().trim()).split("\\s+");
            int n=Integer.parseInt(inpu[0]);
            Long a=Long.parseLong(inpu[1]);
            Long b=Long.parseLong(inpu[2]);
            Long c=Long.parseLong(inpu[3]);
            long lcmab=(a*b)/gcd(a,b);
            long lcmbc=(b*c)/gcd(b,c);
            long lcmca=(c*a)/gcd(c,a);
            long lcmabc=(lcmab*c)/gcd(lcmab,c);
            long l=Math.min(Math.min(a,b),c);
            long h= (long) (2*Math.pow(10,9));
            System.out.println(search(n,l,h,a,b,c,lcmab,lcmbc,lcmca,lcmabc));
            t--;
        }

    }
    static Long search(int n,long l,long h,long a,long b,long c,long lcmab,long lcmbc,long lcmca,long lcmabc){
      while (l<=h){
          long mid=l+(h-l)/2;
          long count=findpos(mid,a,b,c,lcmab,lcmbc,lcmca,lcmabc);
          if (count>=n){
              if (findpos(mid-1,a,b,c,lcmab,lcmbc,lcmca,lcmabc)<n){
                  return mid;
              }else h=mid-1;
          }else l=mid+1;
      }
      return 0l;
    }
    static long findpos(long mid,long a,long b,long c,long lcmab,long lcmbc,long lcmca,long lcmabc){
        long n1=mid/a;
        long n2=mid/b;
        long n3=mid/c;
        long nab=mid/lcmab;
        long nbc=mid/lcmbc;
        long nca=mid/lcmca;
        long nabc=mid/lcmabc;
        return n1+n2+n3+nabc-nab-nbc-nca;
    }
    static Long gcd(Long a,Long b){
        Long min= Math.min(a,b);
        Long max=Math.max(a,b);
        while (min!=0){
            if (max%min==0)return min;
            else {
                Long temp=max%min;
                max=min;
                min=temp;
            }
        }
        return 0l;
    }
}

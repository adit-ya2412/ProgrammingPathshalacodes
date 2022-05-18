package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class allocatebooks {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]books=new int[n];
        String[]elemtns=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            books[i]=Integer.parseInt(elemtns[i]);
        }
        int noofstudents=Integer.parseInt(in.readLine().trim());

        int min=Integer.MIN_VALUE;
        long sum=0;
        for (int i = 0; i <n ; i++) {
            sum+=books[i];
            min=Math.max(books[i],min);
        }
        System.out.println(searchminmumallocation(min,sum,books,noofstudents));
    }
    static long searchminmumallocation(long l,long h,int[]books,int noofstudents){
        long minval=l;
     while (l<=h){
         long mid=l+(h-l)/2;
         boolean r=greedyplacement(mid,books,noofstudents,minval);
         if (!r){
             l=mid+1;
         }else {
             boolean r1=greedyplacement(mid-1,books,noofstudents,minval);
             if (!r1)return mid;
             else h=mid-1;
         }
     }
     return -1;
    }
    static boolean greedyplacement(long allocationlimit,int[]books,int nofstu,long minval){
        if (allocationlimit< minval)return false;
        int s=0;
        int cnt=1;
        for (int i = 0; i < books.length ; i++) {
            if (s+books[i]<=allocationlimit){
                s+=books[i];
            }else {
                cnt++;
                s=books[i];
            }
        }
        return cnt<=nofstu;
    }
}

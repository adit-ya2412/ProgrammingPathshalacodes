package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Capacitytoshippackages {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        String[]elements=(in.readLine().trim()).split("\\s+");
        long max=0;
        long min=Integer.MIN_VALUE;
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            min=Math.max(min,Integer.parseInt(elements[i]));
            max+=Integer.parseInt(elements[i]);
            arr[i]=Integer.parseInt(elements[i]);
        }
        int t=Integer.parseInt(in.readLine().trim());
        while (t!=0){
            int days=Integer.parseInt(in.readLine().trim());
            System.out.println(capacityofship(min, max,arr,days));
            t--;
        }

    }
    static long capacityofship(long min,long max,int[]arr,int days){
        while (min<max){
            long mid=min+(max-min)/2;
            long time=timetaken(mid,arr);
            if (time<=days){
                max=mid;
            }else if (time>days){
                min=mid+1;
            }
        }
        return max;
    }

    static long timetaken(long capacity,int[]cargo){
        long sum=0;
        long days=1;
        for (int i = 0; i <cargo.length ; i++) {
            if (sum+cargo[i]<=capacity){
                sum+=cargo[i];
            }else {
                sum=cargo[i];
                days++;
            }
        }
        return days;
    }
}

package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class placethecows {
    public static void main(String[] args)throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        long[]stalls=new long[n];
        String[]elements=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            stalls[i]=Long.parseLong(elements[i]);
        }
        Arrays.sort(stalls);
        int t=Integer.parseInt(in.readLine().trim());
        while (t!=0){
            int cows=Integer.parseInt(in.readLine().trim());
            if (cows>stalls.length) System.out.println(0);
            else System.out.println(searchmax(0,stalls[n-1]-stalls[0],stalls,cows));
            t--;
        }
    }
    static long searchmax(long l,long h,long[]shops,int cows){
        while (l<=h){
            long mid=l+(h-l)/2;
           if (isposition(shops,mid,cows)){
               if (!isposition(shops,mid+1,cows))return mid;
               else l=mid+1;
           }else h=mid-1;
        }
        return 0;
    }
    static boolean isposition(long[]arr,long m,int cows){
        int cnt=1;long pre=arr[0];
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]-pre<m)continue;
            else {
                cnt++;
                pre=arr[i];
            }
        }
        return cnt>=cows;
    }
}

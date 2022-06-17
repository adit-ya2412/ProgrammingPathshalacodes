package com.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
class pairsanddigits{
    int number;
    int digits;
    pairsanddigits(int number,int digits){
        this.digits=digits;
        this.number=number;
    }

}
public class radixsort {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        List<pairsanddigits>list=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            list.add(new pairsanddigits(arr[i],arr[i]));
        }
        radixsort(arr,list);
        System.out.println(Arrays.toString(arr));
    }
    static void radixsort(int[]arr,List<pairsanddigits>list){
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length ; i++) {
            Math.max(max,arr[i]);
        }
        int digits=(int)Math.floor(Math.log10(max)+1);

            int[]ar1=countsort(arr,digits,list);
            for (int i = 0; i <arr.length ; i++) {
                arr[i]=ar1[i];
        }
    }
    static int[] countsort(int[]arr,int digits,List<pairsanddigits>list){
        int[]ans=new int[arr.length];
        while (digits!=0){
            int[]freq=new int[9];
            for (int i = list.size(); i>=0 ; i--) {
                int n=list.get(i).digits;
                int r=n%10;
                freq[r]++;
            }
            for (int i = 1; i < freq.length ; i++) {
                freq[i]+=freq[i-1];
            }
        }
        return ans;
    }
}

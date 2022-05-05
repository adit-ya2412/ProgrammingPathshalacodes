package com.ac;

import java.util.Scanner;

public class searchakey {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[]arr=new long[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextLong();
        }
        int t=sc.nextInt();
        while (t!=0){
            Long ke=sc.nextLong();
            System.out.println(findindex(arr,ke));
            t--;
        }
    }
    static int findindex(long[]arr,long ke){
        int l=0;
        int h=arr.length-1;
        while (l<=h){
            int mid=l+((h-l)/2);
            if (arr[mid]<ke){
                l=mid+1;
            }else if (arr[mid]>ke){
                h=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}

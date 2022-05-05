package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class findstartingandending {
    public static void main(String[] args) throws IOException {
        BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(sc.readLine().trim());
        long[]arr=new long[n];
        String[] splits=(sc.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(splits[i]);
        }
        int t=Integer.parseInt(sc.readLine().trim());
        while (t!=0){
            int key=Integer.parseInt(sc.readLine().trim());
            int firstindex=findindexfirst(arr,key);

            if (firstindex!=-1){
                System.out.print(firstindex);
                System.out.println(findlastindexof(arr,key));
            }else System.out.println(-1);
            t--;
        }
    }
    static int findindexfirst(long[]arr,int key){
        int l=0;
        int h= arr.length-1;
        while (l<=h){
            int mid=l+((h-l)/2);
            if (arr[mid]>key){
                h=mid-1;
            }else if (arr[mid]<key){
                l=mid+1;
            }else {
                if (mid!=0&&arr[mid-1]!=key)return mid+1;
                if (mid==0)return mid+1;
                //if (arr[mid-1]!=key)return mid+1;
                h=mid-1;
            }
        }
        return -1;
    }
    static int findlastindexof(long[]arr,int key){
        int l=0;
        int h=arr.length-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (arr[mid]<key){
                l=mid+1;
            }else if (arr[mid]>key){
                h=mid-1;
            }else {
                if (mid==arr.length-1)return mid+1;
                else if (arr[mid+1]!=key)return mid+1;
                l=mid+1;
            }
        }
        return -1;
    }
}

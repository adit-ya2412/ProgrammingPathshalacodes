package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class indexofinsertion {
    public static void main(String[] args) throws IOException {
        //Scanner sc=new Scanner(System.in);
        BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(inp.readLine().trim());
        long[]arr=new long[n];
        String[] splits = (inp.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i] = ( Integer.parseInt(splits[i]) );
        }
        int t = Integer.parseInt(inp.readLine().trim());
        while (t!=0){
            int key = Integer.parseInt(inp.readLine().trim());
            System.out.print(findindex(arr,key));
            t--;
        }
    }
    static int findindex(long[]arr,long k){
        int l=0;
        int h=arr.length-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (arr[mid]<k){
                l=mid+1;
            }else if (arr[mid]>k){
                h=mid-1;
            }else {
                return mid;
            }
        }
        return l;
    }
}

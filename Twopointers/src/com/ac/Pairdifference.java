package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pairdifference {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String[]input=(in.readLine().trim()).split("\\s+");
        int n=Integer.parseInt(input[0]);
        int[]arr=new int[n];
        String[]elements=(in.readLine().trim().split("\\s+"));
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        Arrays.sort(arr);
        int difference=Integer.parseInt(input[1]);
        System.out.println(pairdifference(arr,difference));
    }
    static int pairdifference(int[]arr,int difference){
         int ans=0;
        if (arr.length==1)return 0;
        int l=0;
        int r=1;
        int currdiff=0;
        while (r!=arr.length){
            currdiff=arr[r]-arr[l];
            if (currdiff>difference){
                l++;
                if (l==r)r++;
            }else if (currdiff<difference){
                r++;
            }else {
                int c1=0,c2=0,p=arr[l],q=arr[r];
                if (difference==0){

                    while (l< arr.length&&arr[l]==p){
                        l++;r++;
                        c1++;
                    }
                    ans+=(c1*(c1-1)/2);
                }else {
                    while (l<arr.length&&arr[l]==p){
                        c1++;
                        l++;
                    }
                    while (r<arr.length&&arr[r]==q){
                        c2++;
                        r++;
                    }
                    ans+=(c1*c2);
                }
            }
        }
        return ans;
    }
}

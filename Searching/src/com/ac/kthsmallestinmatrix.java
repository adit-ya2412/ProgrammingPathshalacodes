package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kthsmallestinmatrix {
    public static void main(String[] args)throws IOException {
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(inp.readLine().trim());
        int[][]arr=new int[n][n];
        for (int i = 0; i <n ; i++) {
            String[]elements=(inp.readLine().trim()).split("\\s+");
            for (int j = 0; j <n ; j++) {
                arr[i][j]=Integer.parseInt(elements[j]);
            }
        }
        int k=Integer.parseInt(inp.readLine().trim());
        System.out.println(search(arr,k));
    }
    static int search(int[][]arr,int k){
        int[]maxandmin=findminandmax(arr);
        int min=maxandmin[0];
        int max=maxandmin[1];
        int l=min;
        int h=max;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (findjustgreatestelement(arr,mid)>=k){
                if (findjustgreatestelement(arr,mid-1)<k)return mid;
                else h=mid-1;
            }else l=mid+1;
        }
        return -1;
    }
    static int[]findminandmax(int[][]arr){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            min=Math.min(arr[i][0],min);
            max=Math.max(arr[i][arr[0].length-1],max);
        }
        return new int[]{min,max};
    }
    static int findjustgreatestelement(int[][]arr,int k){
        int count=0;
        for (int i = 0; i <arr.length ; i++) {
            int l=0;
           int h=arr[i].length-1;
           while (l<=h){
               int mid=l+(h-l)/2;
               if (arr[i][mid]<=k){
                   l=mid+1;
               }else {
                   h=mid-1;
               }
           }
           count+=l;
        }
        return count;
    }
}

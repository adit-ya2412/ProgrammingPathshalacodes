package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class searchinRotatedbinaryarray {
    public static void main(String[] args)throws IOException {
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(inp.readLine().trim());
        int[]arr=new int[n];
        String[]elemnets=(inp.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elemnets[i]);
        }
        int findpi=findpivot(arr);
        int t=Integer.parseInt(inp.readLine().trim());
        while (t!=0){
            int key=Integer.parseInt(inp.readLine().trim());
            int firsthalf=search(arr,0,findpi,key);
            if (firsthalf==-1){
                int secondhalf=search(arr,findpi+1,arr.length-1,key);
                System.out.println(secondhalf);
            }else System.out.println(firsthalf);
            t--;
        }
    }
    static int search(int[]arr,int st,int end,int key){
        while (st<=end){
            int mid=st+(end-st)/2;
            if (arr[mid]>key){
                end=mid-1;
            }else if (arr[mid]<key){
                st=mid+1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    static int findpivot(int[]arr){
        int l=0;
        int h=arr.length-1;
        while (l<=h){
            int  mi=l+(h-l)/2;
            if (arr[mi]<arr[arr.length-1]){
                h=mi-1;
            }else {
                if (mi!=arr.length-1&&arr[mi]>arr[mi+1]){
                    return mi;
                }
                l=mi+1;
            }
        }
        return -1;
    }
}

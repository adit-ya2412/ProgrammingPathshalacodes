package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class findfrequency {
    public static void main(String[] args)throws IOException {
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(inp.readLine().trim());
        long[]arr=new long[n];
        String[] elements=(inp.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(elements[i]);
        }
        int t=Integer.parseInt(inp.readLine().trim());
        while (t!=0){
            int key=Integer.parseInt(inp.readLine().trim());
            System.out.println(frequency(arr,key));
            t--;
        }
    }
    static int frequency(long[]arr,int key){
        int firstindex=firstoccurennce(arr,key,true);
        if (firstindex!=-1){
            int lastindex=firstoccurennce(arr,key,false);
            return (Math.abs(firstindex-lastindex)+1);
        }
        return 0;
    }
    static int firstoccurennce(long[]arr,int key,boolean first){
        int l=0;
        int h=arr.length-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if (arr[mid]<key){
                l=mid+1;
            }else if (arr[mid]>key){
                h=mid-1;
            }else {
                if (first){
                    if (mid!=0&&arr[mid-1]!=key)return mid+1;
                    if (mid==0)return mid+1;
                    h=mid-1;
                }else {
                    if (mid== arr.length-1)return mid+1;
                    if (arr[mid+1]!=key)return mid+1;
                    l=mid+1;
                }
            }

        }
        return -1;
    }

}

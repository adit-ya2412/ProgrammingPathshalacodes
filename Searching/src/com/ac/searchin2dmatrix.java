package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class searchin2dmatrix {
    public static void main(String[] args)throws IOException {
        BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
        String[]dimensions=(inp.readLine().trim()).split("\\s+");
        int[][]arr=new int[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];
        for (int i = 0; i <Integer.parseInt(dimensions[0]) ; i++) {
            String[]elements=(inp.readLine().trim()).split("\\s+");
            for (int j = 0; j <Integer.parseInt(dimensions[1]) ; j++) {
                arr[i][j]=Integer.parseInt(elements[j]);
            }
        }
        int t=Integer.parseInt(inp.readLine().trim());
        while (t!=0){
            int k=Integer.parseInt(inp.readLine().trim());
            System.out.println(search(arr,k));
            t--;
        }
    }
//    static boolean search(int[][]arr,int key){
//        int st=0;
//        int l=arr[0].length-1;
//        while (st< arr.length&&l>=0){
//            if (key<arr[st][l]){
//                l=l-1;
//            }else if (key>arr[st][l]){
//                st=st+1;
//            }else {
//                return true;
//            }
//        }
//        return false;
//    }
    static boolean search(int[][]arr,int key){
        int c=arr[0].length;
        int l=0;
        int h=(arr.length*arr[0].length)-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            int er=mid/c;
            int ec=mid%c;
            if (arr[er][ec]>key){
                h=mid-1;
            }else if (arr[er][ec]<key){
                l=mid+1;
            }else return true;
        }
        return false;
    }
}

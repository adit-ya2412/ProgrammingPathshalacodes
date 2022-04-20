package com.ac;

import java.util.Arrays;

public class searchinginasorted2Darray {
    public static void main(String[] args) {
      int[][]arr={{10,20,30,40},{15,25,35,45},{27,29,37,48}};
        System.out.println((search(arr,16)));
    }
//    static int[] search(int[][]arr,int key){
//        int stcol=arr[0].length-1;
//        int strow=0;
//        while (strow<arr.length&&stcol>=0){
//            if (arr[strow][stcol]<key){
//                strow++;
//            }else if (arr[strow][stcol]>key){
//                stcol--;
//            }else {
//                return new int[]{strow,stcol};
//            }
//        }
//        return new int[]{-1,-1};
//    }
    static boolean search(int[][]arr,int key){
        int stcol=arr[0].length-1;
        int strow=0;
        while (strow<arr.length&&stcol>=0){
            if (arr[strow][stcol]<key){
                strow++;
            }else if (arr[strow][stcol]>key){
                stcol--;
            }else {
                return true;
            }
        }
        return false;
    }
}

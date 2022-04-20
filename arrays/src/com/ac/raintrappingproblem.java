package com.ac;

import java.util.ArrayList;
import java.util.List;

public class raintrappingproblem {
    public static void main(String[] args) {
        int arr[]={4,2,0,3,2,5};
        System.out.println(total(arr));
    }
    static int total(int []arr){
        List<Integer>pmax=new ArrayList<>();
        pmax.add(arr[0]);
        for (int i = 1; i <arr.length ; i++) {
            pmax.add(Math.max(pmax.get(i-1),arr[i]));
        }
        int[]smax=new int[arr.length];
        smax[arr.length-1]=arr[arr.length-1];
        for (int i =arr.length-2; i >=0 ; i--) {
            smax[i]=Math.max(smax[i+1],arr[i]);
        }
        int amnt=0;
        for (int i = 1; i <arr.length-1 ; i++) {
            int leftheight=pmax.get(i-1);
            int rightheight=smax[i+1];
            int decidningheight=Math.min(leftheight,rightheight);
            if (decidningheight>arr[i]){
                amnt+=decidningheight-arr[i];
            }
        }
        return amnt;
    }
}

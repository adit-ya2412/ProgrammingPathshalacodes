package com.ac;

import java.util.ArrayList;
import java.util.List;

public class prefixsum {

    public static void main(String[] args) {
        int[]arr={2,5,1,7,0,4};
        System.out.println(sumofsubarray(arr,2,5));
    }
    static int sumofsubarray(int[]arr,int i,int j){
        List<Integer>ls=presum(arr);
        if (i==0)return ls.get(j);
        return (ls.get(j)-ls.get(i-1));
    }
    static List  presum(int[]arr){
        List<Integer>ls=new ArrayList<>();
        ls.add(arr[0]);
        for (int i = 1; i <arr.length ; i++) {
            ls.add(ls.get(i-1)+arr[i]);
        }
        return ls;
    }
}

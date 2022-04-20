package com.ac;

import java.util.ArrayList;
import java.util.List;

public class Maxchunks769 {
    public static void main(String[] args) {
        int[]arr={1,0,2,3,4};
        System.out.println(maxchinks(arr));
    }
//    static int maxchinks(int[]arr){
//        List<Integer>ls=new ArrayList<>();
//        int ans=0;
//        if (arr[0]==0){
//            ls.add(arr[0]);
//            ans++;
//        }else {
//            ls.add(arr[0]);
//        }
//        for (int i = 1; i <arr.length ; i++) {
//            ls.add(Math.max(ls.get(i-1),arr[i]));
//            if (ls.get(i)==i)ans++;
//        }
//        return ans;
//    }
    static int maxchinks(int[]arr){
        int ans=0;
        int cmax=Integer.MIN_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            cmax=Math.max(cmax,arr[i]);
            if (cmax==i)ans++;
        }
        return ans;
    }
}

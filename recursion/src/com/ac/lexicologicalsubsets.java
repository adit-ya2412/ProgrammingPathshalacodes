package com.ac;

import java.lang.reflect.Array;
import java.util.Arrays;

public class lexicologicalsubsets {
    public static void main(String[] args) {
      int[]nums={1,2,3,4};
      int[]ans=new int[nums.length];
      print(nums,0,ans,0);
        //System.out.println(Arrays.toString(nums).substring(0));
    }
    static void print(int[]nums,int i,int[] st,int sz){
        if(i==nums.length){
            return;
        }
        for (int j = i; j <nums.length ; j++) {
            st[sz]=nums[j];
            for (int k = 0; k <sz+1 ; k++) {
                System.out.print(st[k]+" ,");
            }
            System.out.println();
            print(nums,j+1,st,sz+1);
        }
    }

}

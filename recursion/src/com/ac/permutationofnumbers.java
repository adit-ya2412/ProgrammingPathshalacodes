package com.ac;

import java.util.ArrayList;
import java.util.List;

public class permutationofnumbers {
    public static void main(String[] args) {
          List<List<Integer>>ans=new ArrayList<>();
          int[]nums={1,2,3};
          perm(nums,0,ans);
        System.out.println(ans);
    }
    static void perm(int[]nums, int i, List<List<Integer>>ans){
        if (i==nums.length){
            List<Integer>temp=new ArrayList<>();
            for (int j = 0; j <nums.length ; j++) {
                temp.add(nums[j]);
            }
            ans.add(temp);
            return;
        }
        for (int j = i; j <nums.length ; j++) {
            if (i!=j){
                nums=swap(nums,i,j);
                perm(nums,i+1,ans);
                nums=swap(nums,i,j);
            }else {
                perm(nums,i+1,ans);
            }

        }
    }
    static int[] swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return arr;
    }
}

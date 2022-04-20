package com.ac;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
    public static void main(String[] args) {
     List<List<Integer>>ans=new ArrayList<>();
     int[]nums={1,1,2};
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
        int[]freq=new int[21];
        for (int j = i; j <nums.length ; j++) {
            if (freq[nums[j]+10]==0){
                nums=swap(nums,i,j);
                perm(nums,i+1,ans);
                nums=swap(nums,i,j);
            }
            freq[nums[j]+10]++;
        }
    }
    static int[]swap(int[]nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        return nums;
    }
}

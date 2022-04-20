package com.ac;

public class sumofsubsets {
    public static void main(String[] args) {
        int[]arr={1,2,-3};
       subsetsum(arr,0,3);
        System.out.println(c);
        System.out.println(subsetsum1(arr,0,3));
    }
    static int c=0;
    static void subsetsum(int[]nums,int i,int s){
        if (i==nums.length){
            if (s==0)c++;
            return;
        }
        subsetsum(nums,i+1,s-nums[i]);
        subsetsum(nums,i+1,s);
    }
    static int subsetsum1(int[]nums,int i,int s){
        if (i==nums.length){
            if (s==0){
                return 1;
            }else return 0;
        }
        return subsetsum1(nums,i+1,s-nums[i])+subsetsum1(nums,i+1,s);
    }
}

package com.ac;

import java.util.ArrayList;
import java.util.List;

public class subsetusingbitmasking {
    public static void main(String[] args) {
          int[]nums={1,2,3};
        System.out.println(subset(nums));
    }
    static List<List<Integer>> subset(int[]nums){
        List<List<Integer>>output=new ArrayList<>();
        int[]s=new int[nums.length];
        for (int i = 0; i <=Math.pow(2,nums.length)-1 ; i++) {
           List<Integer>subs=new ArrayList<>();
            for (int j = 0; j <nums.length ; j++) {
                if ((i&(1<<j))>0){
                subs.add(nums[j]);
                }
            }
            output.add(subs);
        }
        return output;
    }
}

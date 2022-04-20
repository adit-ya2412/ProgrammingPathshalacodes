package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class subsets {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]nums=new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i]=sc.nextInt();
        }
        subsets(nums,0,new ArrayList<>(),0);
        System.out.println(ans1);
    }
    static List<List<Integer>>ans1=new ArrayList<>();

    static void subsets(int[]nums,int i,List<Integer>ans,int sz){
        if (i>nums.length-1){
            List<Integer>ls=new ArrayList<>();
            for (int j = 0; j <sz ; j++) {
                ls.add(j,ans.get(j));
            }
            ans1.add(ls);
            return;
        }
        ans.add(sz,nums[i]);
        subsets(nums,i+1,ans,sz+1);
        subsets(nums,i+1,ans,sz);
    }
}

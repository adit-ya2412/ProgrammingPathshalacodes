package com.ac;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class sum4ii {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n1= Integer.parseInt(br.readLine().trim());
        int[]nums1=new int[n1];
        int[]nums2=new int[n1];
        int[]nums3=new int[n1];
        int[]nums4=new int[n1];
        String[]nums;
        for (int i = 0; i <4 ; i++) {
            nums=(br.readLine().trim()).split("\\s+");
            if (i==0){
                for (int j = 0; j <n1 ; j++) {
                    nums1[j]=Integer.parseInt(nums[j]);
                }
            }
            if (i==1){
                for (int j = 0; j <n1 ; j++) {
                    nums2[j]=Integer.parseInt(nums[j]);
                }
            }
            if (i==2){
                for (int j = 0; j <n1 ; j++) {
                    nums3[j]=Integer.parseInt(nums[j]);
                }
            }
            if (i==3){
                for (int j = 0; j <n1 ; j++) {
                    nums4[j]=Integer.parseInt(nums[j]);
                }
            }
        }
        System.out.println(count(nums1,nums2,nums3,nums4));
    }
    static int count(int[]nums1,int[]nums2,int[]nums3,int[]nums4){
        List<Integer>sumoffirsttwo=new ArrayList<>();
        for (int i = 0; i <nums1.length ; i++) {
            for (int j = 0; j <nums2.length ; j++) {
                sumoffirsttwo.add(nums1[i]+nums2[j]);
            }
        }
        HashMap<Integer,Integer>sumoflastwo=new HashMap<>();
        for (int i = 0; i <nums3.length ; i++) {
            for (int j = 0; j <nums4.length ; j++) {
                if (sumoflastwo.get(nums3[i]+nums4[j])!=null){
                    sumoflastwo.put(nums3[i]+nums4[j],sumoflastwo.get(nums3[i]+nums4[j])+1);
                }else {
                    sumoflastwo.put(nums3[i]+nums4[j],1);
                }
            }
        }
        int ans=0;
        for (int a:sumoffirsttwo) {
            if (sumoflastwo.containsKey(-1*a)){
                ans+=sumoflastwo.get(-1*a);
            }
        }
        return ans;
    }
}

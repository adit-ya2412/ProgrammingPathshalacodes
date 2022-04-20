package com.ac;

import java.util.ArrayList;
import java.util.List;

public class MajorityelementII229 {
    public static void main(String[] args) {
      int[]arr={-1,-1,-1};
        System.out.println(major(arr));
    }
    static List<Integer> major(int[]arr){
        int num1=-1,num2=-1,c1=0,c2=0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==num1){
                c1++;
            }else if (arr[i]==num2){
                c2++;
            }else if (c1==0){
                num1=arr[i];
                c1++;
            }else if (c2==0){
                num2=arr[i];
                c2++;
            }else {
                c1--;
                c2--;
            }
        }
        int freq1=0,freq2=0;
        List<Integer>ans=new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==num1)freq1++;
            else if (arr[i]==num2)freq2++;
        }
        if (freq1>(arr.length/3)){
            ans.add(num1);
        }
        if (freq2>(arr.length)/3)ans.add(num2);

        return ans;
    }
}

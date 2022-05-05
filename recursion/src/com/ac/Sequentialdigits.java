package com.ac;

import java.util.*;

public class Sequentialdigits {
    public static void main(String[] args) {
      List<Integer>ans=new ArrayList<>();
      squenceadd(ans,1000,13000);
        Collections.sort(ans);
        System.out.println(ans);
    }
    static void squenceadd(List<Integer>ans,int l,int h){
        for (int i = 1; i <=9 ; i++) {
            helper(i,ans,0,l,h);
        }
    }
    static void helper(int i,List<Integer>ans,int num,int l,int h){
        if (num>=l&&num<=h){
            ans.add(num);
        }
        if (num>h||i>9)return;
            helper(i+1,ans,num*10+i,l,h);

    }
}

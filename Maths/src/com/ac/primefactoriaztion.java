package com.ac;

import java.util.ArrayList;
import java.util.List;

public class primefactoriaztion {
    public static void main(String[] args) {
        System.out.println(primefactors(111));
    }
    static List primefactors(int n){
        List<Integer>ans=new ArrayList<>();
        int num=n;
        for (int i=2;i*i<=num;){
            if (n%i==0){
                n=n/i;
                ans.add(i);
            }else {
                i++;
            }
        }
        if (n!=1)ans.add(n);
        return ans;
    }
}

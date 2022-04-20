package com.ac;

import java.util.ArrayList;
import java.util.List;

public class pascaltriangle118 {
    public static void main(String[] args) {
        System.out.println(number(3));
    }
    static List<List<Integer>> number(int n){
        List<List<Integer>>ans=new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                List<Integer>temp=new ArrayList<>();
                for (int j = 0; j <i+1 ; j++) {
                    if (j==0||j==i){
                        temp.add(1);
                    }else {
                        List<Integer> pre_r = ans.get(i-1);
                      temp.add(pre_r.get(j-1)+pre_r.get(j));
                    }
                }
                ans.add(temp);
            }
            return ans;

    }
}

package com.ac;

import java.util.ArrayList;
import java.util.List;

public class combinationsumIII {
    public static void main(String[] args) {
 List<List<Integer>>ans=new ArrayList<>();
 subsets(1,1,4,ans,new ArrayList<>());
        System.out.println(ans);
    }
    static void subsets(int n, int i, int k, List<List<Integer>>ans,List<Integer>temp) {
        if (k==0){
            if (n==0){
                ans.add(new ArrayList<>(temp));
                return;
            }
            return;
        }
        for (int j = i; j <=9 ; j++) {
            temp.add(j);
            int s=n-j;
            int d=k-1;
            subsets(s,j+1,d,ans,temp);
            temp.remove(temp.size()-1);
        }
    }

}

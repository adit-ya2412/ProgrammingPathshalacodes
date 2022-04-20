package com.ac;

import java.util.ArrayList;
import java.util.List;

public class combioflengthk {
    public static void main(String[] args) {
        List<List<Integer>>ans=new ArrayList<>();
     combine(4,2,1,new ArrayList<>(),ans);
        System.out.println(ans);
    }

    static void combine(int n,int k,int i,List<Integer>temp,List<List<Integer>>ans){
        if (temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int j = i; j <=n ; j++) {
            temp.add(j);
            combine(n,k,j+1,temp,ans);
            temp.remove(temp.size()-1);
        }
    }

}

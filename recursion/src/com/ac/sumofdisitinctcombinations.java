package com.ac;

import java.util.ArrayList;
import java.util.List;

public class sumofdisitinctcombinations {
    public static void main(String[] args) {
        int[]arr={2,3,6,7};
        List<List<Integer>>ans=new ArrayList<>();
        //System.out.println(count(arr,7,0));
        combinations(arr,7,0,ans,new ArrayList<>());
        System.out.println(ans);
    }
    static int count(int[]arr,int s,int i){
        if (i==arr.length){
            return 0;
//            if (s==0)return 1;
//            else return 0;
        }
        if (s<0)return 0;
        if (s==0)return 1;
        return count(arr,s-arr[i],i)+
        count(arr,s,i+1);
    }
    static void combinations(int[]arr, int s, int i, List<List<Integer>>ans,List<Integer>temp){
        if (i==arr.length){
            return;
        }
        if (s<0)return;
        if (s==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

            temp.add(arr[i]);
            combinations(arr,s-arr[i],i,ans,temp);
            temp.remove(temp.size()-1);
            combinations(arr,s,i+1,ans,temp);

    }
}

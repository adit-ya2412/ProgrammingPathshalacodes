package com.ac;

import javafx.util.Pair;

import java.util.*;

public class paths {
    public static void main(String[] args) {
    int[][]arr={{0,0,1,1},
            {0,0,1,0},
            {1,0,1,1},
            {0,0,0,0}};
    List<List<Integer>>ans=new ArrayList<>();

    traverse(arr,0,0,ans,new ArrayList<>());
        System.out.println(ans);
    }
    static void traverse(int[][]arr, int i, int j, List<List<Integer>> ans,List<Integer>an){
        if (i==j&&j==arr[i].length-1){
            an.add(i);
            an.add(j);
            ans.add(new ArrayList<>(an));
            an.remove(an.size()-1);
            an.remove(an.size()-1);
            return;
        }
        if (arr[i][j]==1)return;
        an.add(i);
        an.add(j);
        if (i==arr.length-1){
            traverse(arr,i,j+1,ans,an);
        }else if (j==arr[i].length-1){
            traverse(arr,i+1,j,ans,an);
        }else {
            traverse(arr,i,j+1,ans,an);
            traverse(arr,i+1,j,ans,an);
        }
        an.remove(an.size()-1);
        an.remove(an.size()-1);
    }
}

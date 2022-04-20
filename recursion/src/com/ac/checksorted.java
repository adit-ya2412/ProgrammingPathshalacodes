package com.ac;

import java.util.ArrayList;
import java.util.List;

public class checksorted {
    public static void main(String[] args) {
        int[]arr={1,3,5,7,6,7,8,9,10};
       // System.out.println(check(arr,0));
        //System.out.println(linearsearch(arr,0,8));
        List<Integer>index=new ArrayList<>();
        System.out.println(findindex(arr,0,7));
    }
    static boolean check(int[]arr,int i){
        if (i== arr.length-1)return true;
        return (arr[i]<arr[i+1]&&(check(arr,i+1)));
    }
    static boolean linearsearch(int[]arr,int i,int target){
        if (arr[i]==target)return true;
        if (i==arr.length-1)return false;
        return linearsearch(arr,i+1,target);
    }
    static List findindex(int[]arr,int i,int target,List<Integer>index){
        if (i==arr.length-1){
            return index;
        }
        if (arr[i]==target){
            index.add(i);
            return findindex(arr,i+1,target,index);
        }else {
            return findindex(arr,i+1,target,index);
        }
    }
    static List findindex(int[]arr,int i,int target){
        List<Integer>ind=new ArrayList<>();
        if (i==arr.length-1){
            return ind;
        }
        if (arr[i]==target){
            ind.add(i);
        }
        List<Integer>ansfromothercalls=findindex(arr,i+1,target);
        ind.addAll(ansfromothercalls);
        return ind;
    }
}

package com.ac;

import java.util.ArrayList;
import java.util.List;

public class suffixmax {
    public static void main(String[] args) {
        int[]arr={5,10,0,4,2,7};
        System.out.println(min(arr,2));
    }
    static int max(int[]arr,int i){
        List<Integer>ls=new ArrayList<>();
        ls.add(arr[arr.length-1]);
        for (int j =arr.length-2; j >=0 ; j--) {
            ls.add(Math.max(ls.get(arr.length-j-2),arr[j]));
        }
        return ls.get(i);
    }
    static int min(int[]arr,int i){
        List<Integer>ls=new ArrayList<>();
        ls.add(arr[arr.length-1]);
        for (int j =arr.length-2; j >=0 ; j--) {
            ls.add(Math.min(ls.get(arr.length-j-2),arr[j]));
        }
        return ls.get(i);
    }
}

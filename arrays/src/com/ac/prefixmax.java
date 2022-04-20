package com.ac;

import java.util.ArrayList;
import java.util.List;

public class prefixmax {
    public static void main(String[] args) {
     int[]arr={5,-1,0,4,2,7};
        System.out.println(premax(arr,3));
    }
    static int premax(int[]arr,int i){
        List<Integer>ls=new ArrayList<>();
        ls.add(arr[0]);
        for (int k = 1; k <arr.length ; k++) {
            ls.add(Math.max(ls.get(k-1),arr[k]));
        }
        return ls.get(i);
    }
}

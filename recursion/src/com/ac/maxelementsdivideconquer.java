package com.ac;

public class maxelementsdivideconquer {
    public static void main(String[] args) {
        int[]arr={7,1,4,3,2,6,5};
        System.out.println(max(0,6,arr));
    }
    static int max(int st,int end,int[]arr){
        if (st==end){
            return arr[st];
        }else {
            return Math.max(max(st,(end+st)/2,arr),max(((end+st)/2)+1,end,arr));
        }
    }
}

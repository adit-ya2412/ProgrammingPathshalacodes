package com.ac;

import java.util.ArrayList;
import java.util.List;

public class subsetsofset {
    public static void main(String[] args) {
     int[]arr={1,2,3};
     int[]temp=new int[arr.length];
     pass(arr,3,0,temp,0);
    }
     static void pass(int[]arr,int n,int i,int []temp,int sz){
        if (i==n){
            for (int j = 0; j <sz ; j++) {
                System.out.print(temp[j]+" ");
            }
            System.out.println("");
            return;
        }
        temp[sz]=arr[i];
        pass(arr,n,i+1,temp,sz+1);
        pass(arr,n,i+1,temp,sz);
    }
}

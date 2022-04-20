package com.ac;

public class findminimumswaps {
    public static void main(String[] args) {
     int[]arr={4,16,3,8,13,2,19,4,12,2,7,17,4,19,1};
        System.out.println(swaps(arr,9));
    }
    static int swaps(int[]arr,int k){
        int legal=0;
        int maxlegal=Integer.MIN_VALUE;
        int elementinwindows=0;
        int win=0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]<=k){
                legal++;
            }
        }
        win=legal;
        for (int i = 0; i <win ; i++) {
            if (arr[i]<=k)elementinwindows++;
        }
        if (elementinwindows>maxlegal)maxlegal=elementinwindows;

        for (int i =win; i <arr.length ; i++) {

            if (arr[i]<=k)elementinwindows++;
            if (arr[i-win]<=k)elementinwindows--;
            if (elementinwindows>maxlegal)maxlegal=elementinwindows;
        }
        return legal-maxlegal;
    }
}

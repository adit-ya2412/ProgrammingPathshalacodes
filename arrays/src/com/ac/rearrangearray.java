package com.ac;

import java.util.Arrays;

public class rearrangearray {
    public static void main(String[] args) {
        long[]arr={2,0,1,4,5,3};
        //System.out.println(Arrays.toString(arrange(arr)));
        System.out.println(Arrays.toString(arrangealternate(arr)));
    }
    static int[] arrange(int[]arr){
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] >= 0) {
                int j = arr[i];
                int value = i;
                while (j != i) {
                    int temp = arr[j];
                    arr[j] = (-(value+1));
                    value =j;
                     j=temp;
                }
                arr[j] = (-(value + 1));
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=((-1*(arr[i]))-1);
        }
        return arr;
    }
    static long[]arrangealternate(long[]arr){
        int n=arr.length;
        for (int i = 0; i <n;  i++) {
             int oldvalue=(int)(arr[i]%n);//Collecting the old value at base index
             //arr[oldvalue]=(n*i+arr[oldvalue]);//changing the value at new index +whatever was there at that index
             long newnum=n*i;
             arr[oldvalue]=(newnum+arr[oldvalue]);
        }
        for (int i = 0; i <n ; i++) {
            arr[i]=arr[i]/n;
        }
        return arr;
    }
}

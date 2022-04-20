package com.ac;

import java.util.Arrays;

public class rotateimage48 {
    public static void main(String[] args) {
        int[][]arr={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(rotate(arr)));
    }
    static int[][]rotate(int[][]arr){
        arr=transpose(arr);
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr.length/2 ; j++) {
                int temp=arr[i][j];
                arr[i][j]=arr[i][arr.length-1-j];
                arr[i][arr.length-1-j]=temp;
            }

        }
        return arr;
    }
    static int[][]transpose(int[][]arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i; j <arr[0].length ; j++) {
                if (i!=j){
                    int temp=arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=temp;
                }
            }
        }
        return arr;
    }
}

package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class booleanmatrixtransformation {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String[]ele=(in.readLine().trim()).split("\\s+");
        int[][]arr=new int[Integer.parseInt(ele[0])][Integer.parseInt(ele[1])];
        int m=Integer.parseInt(ele[0]);
        int n=Integer.parseInt(ele[1]);
        for (int i = 0; i <m ; i++) {
            String[]element=(in.readLine().trim()).split("\\s+");
            for (int j = 0; j <n ; j++) {
                arr[i][j]=Integer.parseInt(element[j]);
            }
        }

        transform(arr,m,n);
        for (int[]ar:arr){
            System.out.println(Arrays.toString(ar));
        }

    }
    static void transform(int[][]arr,int row,int column){
        int[]rowarray=new int[row];
        int[]columnarray=new int[column];
        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                if (arr[i][j]==1){
                    rowarray[i]=1;
                    columnarray[j]=1;
                }
            }
        }
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <column ; j++) {
                if (rowarray[i]==1||columnarray[j]==1){
                    arr[i][j]=1;
                }
            }
        }
    }
}

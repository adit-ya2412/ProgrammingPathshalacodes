package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class booleantransformationwithdiagonal {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String[]size=(in.readLine().trim()).split("\\s+");
        int m=Integer.parseInt(size[0]);
        int n=Integer.parseInt(size[1]);
        int[][]arr=new int[m][n];
        String[]ele=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <m ; i++) {
            String[]inputs=(in.readLine().trim()).split("\\s+");
            for (int j = 0; j <n ; j++) {
                arr[i][j]=Integer.parseInt(inputs[j]);
            }
        }
        transform(arr,m,n);
    }
    static void transform(int[][]arr,int row,int column){
        
    }
}

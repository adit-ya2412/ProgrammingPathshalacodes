package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Maximumsidesquarematrix {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String[]size=(in.readLine().trim()).split("\\s+");
        int rows=Integer.parseInt(size[0]);
        int colums=Integer.parseInt(size[1]);
        int[][]matrix=new int[rows][colums];
        for (int i = 0; i <rows ; i++) {
            String[]elements=(in.readLine().trim()).split("\\s+");
            for (int j = 0; j <colums ; j++) {
                matrix[i][j]=Integer.parseInt(elements[j]);
            }
        }
        int[][]precomput=precomputation(matrix);
        int min=1;
        int max=Math.min(rows,colums);
        int t=Integer.parseInt(in.readLine().trim());
        while (t!=0){
            int threshold=Integer.parseInt(in.readLine().trim());
            System.out.println(sizeofsquare(precomput,min,max,threshold));
            t--;
        }
    }
    static int sizeofsquare(int[][]precomput,int min,int max,int threshold){
        while (min<=max){
           int mid=min+(max-min)/2;
           if (ifpossible(mid,precomput,threshold)) {
               if (!ifpossible(mid+1,precomput,threshold)){
                   return mid;
               }else min=mid+1;
           }else {
               max=mid-1;
           }
        }
        return 0;
    }
    static boolean ifpossible(int size,int[][]precomput,int threshold){

        for (int i = 0; i <=precomput.length-size ; i++) {
            for (int j = 0; j <=precomput[i].length-size ; j++) {
                if (sum(precomput,i,j,i+size-1,j+size-1)<=threshold){
                    return true;
                }
            }
        }
        return false;
    }
    static long sum(int[][]precomput,int i1,int j1,int i2,int j2){
        long ans=precomput[i2][j2];
        if (j1-1>=0) {
            ans -= precomput[i2][j1 - 1];
            if (i1-1>=0){
                ans-=precomput[i1-1][j2];
                ans+=precomput[i1-1][j1-1];
            }

        }else {
            if (i1-1>=0){
                ans-=precomput[i1-1][j2];
            }

        }
   return ans;
    }
    static int[][]precomputation(int[][]arr){
        int n=arr.length;
        int m=arr[0].length;;
        int [][]ans=new int[n][m];
        //rowwise
        for (int i = 0; i <n ; i++) {
            ans[i][0]=arr[i][0];
            for (int j = 1; j <m ; j++) {
                ans[i][j]=ans[i][j-1]+arr[i][j];
            }
        }
        //columnwise
        for (int j = 0; j <m ; j++) {
            for (int i = 1; i <n ; i++) {
                ans[i][j]+=ans[i-1][j];
            }
        }
        return ans;

    }
}

package com.ac;

import java.util.Arrays;

public class sumofelementsinsubarray {
    public static void main(String[] args) {
     // int[][]arr={{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
    //int[][]arr={{1,3,5,7},{0,2,4,4},{3,4,2,6}};
        int[][]arr={{1,2,3},{4,5,6},{7,8,9}};
        int[][]ans=prematrix(arr);
        for(int[]i:ans){
            System.out.println(Arrays.toString(i));
        }
        //System.out.println( sum(arr,0,0,2,1));
    }
    static int sum(int[][]arr,int i1,int j1,int i2,int j2){

        int sum=arr[i2][j2];
        if (!(j1-1<0)&&(!(i1-1<0))){
            sum-=arr[i2][j1-1];
            sum-=arr[i1-1][j2];
            sum+=arr[i1-1][j1-1];
        }else{

            if (j1-1<0&&(i1-1>=0)){
                sum-=arr[i1-1][j2];
            }else if (i1-1<0&&(j1-1>=0)){
                sum-=arr[i2][j1-1];
            }
        }
        return sum;
    }
    static int[][] prematrix(int[][]arr){
        int n=arr.length;
        int m=arr[0].length;
        int [][]ans=new int[n][m];

        for (int i = 0; i <arr.length ; i++) {
            ans[i][0]=arr[i][0];
            for (int j = 1; j <arr[0].length ; j++) {
                ans[i][j]=ans[i][j-1]+arr[i][j];
            }
        }
        for (int i = 0; i < ans[0].length ; i++) {
            for (int j =1; j <ans.length ; j++) {
                ans[j][i]=ans[j-1][i]+ans[j][i];
            }
        }
        return ans;
    }
}

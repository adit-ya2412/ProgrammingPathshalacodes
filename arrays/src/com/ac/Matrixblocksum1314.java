package com.ac;

import java.util.Arrays;

public class Matrixblocksum1314 {
    public static void main(String[] args) {
        int[][]arr={{1,2,3},{4,5,6},{7,8,9}};
        int[][]ans=answer(arr,4);
        for (int[]i:ans){
            System.out.println(Arrays.toString(i));
        }
    }
    static int [][]sum(int[][]arr){
        int ans[][]=new int[arr.length][arr[0].length];
        for (int i = 0; i < ans.length ; i++) {
            ans[i][0]=arr[i][0];
            for (int j = 1; j < ans[0].length ; j++) {
                ans[i][j]=ans[i][j-1]+arr[i][j];
            }
        }
        for (int i = 0; i < ans[0].length ; i++) {
            for (int j =1; j <ans.length ; j++) {
                ans[j][i]+=ans[j-1][i];
            }
        }
        return ans;
    }
    static int[][]answer(int[][]arr,int k){
        int[][]prematrix=sum(arr);
        int[][]ans=new int[arr.length][arr[0].length];
        for (int i = 0; i <ans.length ; i++) {
            for (int j = 0; j <ans[0].length ; j++) {
                int i1=0,j1=0,i2=0,j2=0;
                if (i-k>=0){
                    i1=i-k;
                }else {
                    i1=0;
                }
                if(j-k>=0){
                    j1=j-k;
                }else j1=0;
                if (i+k<=ans.length-1){
                    i2=i+k;
                }else {
                    i2=ans.length-1;
                }
                if (j+k<=ans[0].length-1){
                    j2=j+k;
                }else {
                    j2=ans[0].length-1;
                }
                ans[i][j]=calculate(prematrix,i1,j1,i2,j2);
            }
        }
        return ans;

    }
    static int calculate(int[][]arr,int i1,int j1,int i2,int j2){
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
}

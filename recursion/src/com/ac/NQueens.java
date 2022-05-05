package com.ac;

import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
         int r=0;
         int[][]chessboard=new int[8][8];
         printnqueens(r,chessboard);
    }
    static void printnqueens(int r, int[][]chessboard){
        if (r==chessboard.length){
            for (int[]arr:chessboard) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            return;
        }
        for (int i=0;i<chessboard.length;i++){
            if (issafe(chessboard,r,i)){
                chessboard[r][i]=1;
                printnqueens(r+1,chessboard);
                chessboard[r][i]=0;
            }
        }
    }
    static boolean issafe(int[][]arr,int i,int j){
        int temp;
        //upperleftdiagonal
        int temp1;
        temp1=i-1;temp=j-1;
        while (temp1>=0&&temp>=0){
            if (arr[temp1][temp]==1)return false;
            temp1--;
            temp--;
        }
        //upp
        temp1=i-1;
        while (temp1>=0){
            if (arr[temp1][j]==1)return false;
            temp1--;
        }
        //upperrightdiagonal
        temp1=i-1;temp=j+1;
        while (temp1>=0&&temp<arr.length){
            if (arr[temp1][temp]==1)return false;
            temp1--;
            temp++;
        }
        return true;
    }
}

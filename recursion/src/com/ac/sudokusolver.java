package com.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class sudokusolver {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       int[][]board=new int[9][9];
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                board[i][j]=sc.nextInt();
            }
        }
       soduku(board);
        display(board);
        System.out.println(ansfound);

    }
    static void display(int[][]arr){
        for (int[]ar:arr){
            System.out.println(Arrays.toString(ar));
        }
        System.out.println();
    }
   static boolean ansfound=false;
    static void soduku(int[][]board){

        int[][]rowfreq=new int[board.length][board.length];
        int[][]colfreq=new int[board.length][board.length];
        int[][]matrfreq=new int[board.length][board.length];
        //rowfreq
        for (int i = 0; i <rowfreq.length ; i++) {
            for (int j = 0; j <rowfreq.length ; j++) {
                if (board[i][j]!=0){
                    rowfreq[i][board[i][j]-1]++;
                }
            }
        }
        for (int i = 0; i <colfreq.length ; i++) {
            for (int j = 0; j <colfreq.length ; j++) {
                if (board[j][i]!=0){
                    colfreq[i][board[j][i]-1]++;
                }
            }
        }
        int m=0;
        for (int i = 0; i <9 ; i+=3) {
            for (int j = 0; j <9 ; j+=3) {
                for (int k = i; k <i+3 ; k++) {
                    for (int l = j; l <j+3 ; l++) {
                        if (board[k][l]!=0){
                         matrfreq[m][board[k][l]-1]++;
                        }
                    }
                }
                m++;
            }
        }
        int[][]ans=new int[9][9];
        solve(board,0,0,rowfreq,colfreq,matrfreq,ans);

    }
    static void solve(int[][]board,int i,int j,int[][]rowfreq,int[][]colfreq,int[][]matrixfreq,int[][]ans){
        if (ansfound==true)return;
        if (i==9){
            ansfound=true;
            int[][]a;
            a=board.clone();
            ans=a;
            display(ans);
            return;
        }
        if (board[i][j]!=0){
            if (j<8)solve(board, i, j+1, rowfreq, colfreq, matrixfreq, ans);
            else solve(board,i+1,0,rowfreq,colfreq,matrixfreq,ans);
        }else {
            int matrno=findmatno(i,j);
            for (int k = 1; k <=9 ; k++) {
             if (rowfreq[i][k-1]==0&&colfreq[j][k-1]==0&&matrixfreq[matrno][k-1]==0){
                 board[i][j]=k;
                 rowfreq[i][k-1]++;
                 colfreq[j][k-1]++;
                 matrixfreq[matrno][k-1]++;
                 if (j<8)solve(board, i, j+1, rowfreq, colfreq, matrixfreq, ans);
                 else solve(board,i+1,0,rowfreq,colfreq,matrixfreq,ans);
                 //backtrack
                 board[i][j]=0;
                 rowfreq[i][k-1]--;
                 colfreq[j][k-1]--;
                 matrixfreq[matrno][k-1]--;
             }
            }
        }
    }
    static int findmatno(int i,int j){
        if (i<3){
            if (j<3)return 0;
            if (j>2&&j<6)return 1;
            if (j>5)return 2;

        }else if (i>2&&i<6){
            if (j<3)return 3;
            if (j>2&&j<6)return 4;
            if (j>5)return 5;
        }else {
            if (j<3)return 6;
            if (j>2&&j<6)return 7;
            if (j>5)return 8;

        }
        return 0;
    }
}

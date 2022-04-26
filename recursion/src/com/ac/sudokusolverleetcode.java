package com.ac;

import java.util.Arrays;

public class sudokusolverleetcode {
    public static void main(String[] args) {
        char board [][] =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},

                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},

                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},

                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},

                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},

                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},

                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);
        for(char[]ar:board){
            System.out.println(Arrays.toString(ar));
        }
        System.out.println();
    }
    static boolean ansfound=false;
    public static void solveSudoku(char[][] board) {
        int[][]rowfrequency=new int[9][9];
        int[][]colfrequency=new int[9][9];
        int[][]mtrxfrequency=new int[9][9];
        for (int i = 0; i <9; i++) {
            for (int j = 0; j <9 ; j++) {
                if (board[i][j]!='.'){
                    rowfrequency[i][Character.getNumericValue(board[i][j]-1)]++;
                }
            }
        }
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9; j++) {
                if (board[j][i]!='.'){
                    colfrequency[i][Character.getNumericValue(board[j][i]-1)]++;
                }
            }
            }
        int m=0;
        for (int i = 0; i <9 ; i+=3) {
            for (int j = 0; j <9 ; j+=3) {
                for (int k = i; k <i+3 ; k++) {
                    for (int l = j; l <j+3 ; l++) {
                        if (board[k][l]!='.'){
                            mtrxfrequency[m][Character.getNumericValue(board[k][l]-1)]++;
                    }
                }
            }
                m++;
        }
        }
        char[][]ans=new char[9][9];
        solve(board,0,0,rowfrequency,colfrequency,mtrxfrequency,ans);
        for (int i = 0; i <board.length ; i++) {
            board[i]=ans[i].clone();
        }
    }
    static void solve(char[][]board,int i,int j,int[][]rowfreq,int[][]colfreq,int[][]matrxfreq,char[][]ans){
        if (ansfound==true)return;
        if (i==9){
            ansfound=true;
            for (int k = 0; k <board.length ; k++) {
                ans[k]=board[k].clone();
            }
            return;
        }
        if (board[i][j]!='.'){
            if (j<8){
                solve(board, i, j+1, rowfreq, colfreq, matrxfreq, ans);
            }else {
                solve(board, i+1, 0, rowfreq, colfreq, matrxfreq, ans);
            }
        }else {
            int matno=getmatrixno(i,j);
            for (int k = 1; k <=9 ; k++) {
                if (rowfreq[i][k-1]==0&&colfreq[j][k-1]==0&&matrxfreq[matno][k-1]==0){
                    board[i][j]=Integer.toString(k).charAt(0);
                    rowfreq[i][k-1]=1;colfreq[j][k-1]=1;matrxfreq[matno][k-1]=1;
                    if (j<8){
                        solve(board, i, j+1, rowfreq, colfreq, matrxfreq, ans);
                    }else {
                        solve(board, i+1, 0, rowfreq, colfreq, matrxfreq, ans);
                    }
                    board[i][j]='.';
                    rowfreq[i][k-1]=0;colfreq[j][k-1]=0;matrxfreq[matno][k-1]=0;
                }
            }
        }
    }
    static int getmatrixno(int i,int j){
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

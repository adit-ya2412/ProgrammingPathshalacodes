package com.ac;

public class NqueensIILeetcode {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
    static int count=0;
    public static int totalNQueens(int n) {
      int[][]m=new int[n][n];
      solve(m,0);
      return count;
    }
    static void solve(int[][]board,int i){
        if (i==board.length)count++;
        for (int j = 0; j <board.length ; j++) {
            if (issafe(board,i,j)){
                board[i][j]=1;
                solve(board,i+1);
                board[i][j]=0;
            }
        }
    }
    static boolean issafe(int[][]board,int i,int j){
        //up
        int temp1;
        int temp2;
        temp1=i-1;
        while (temp1>=0){
            if (board[temp1][j]==1)return false;
            temp1--;
        }
        //uppleft
        temp1=i-1;temp2=j-1;
        while (temp1>=0&&temp2>=0){
            if (board[temp1][temp2]==1)return false;
            temp1--;
            temp2--;
        }
        //upperright
        temp1=i-1;temp2=j+1;
        while (temp1>=0&&temp2<board.length){
            if (board[temp1][temp2]==1)return false;
            temp1--;
            temp2++;
        }
        return true;
    }
}

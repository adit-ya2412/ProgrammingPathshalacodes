package com.ac;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sorrounded_Regions {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int rows=sc.nextInt();
        int cols=sc.nextInt();
        char[][]board=new char[rows][cols];
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                board[i][j]=sc.next().charAt(0);
            }
        }
        solve(board);
        for (char[]i:board){
            System.out.println(Arrays.toString(i));
        }


    }
    static void solve(char[][]board){
        List<int[]>directions=new ArrayList<>();
        directions.add(new int[]{1,0});
        directions.add(new int[]{-1,0});
        directions.add(new int[]{0,1});
        directions.add(new int[]{0,-1});
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                if (i==0||i==board.length-1||j==0||j== board[0].length-1){
                    if (board[i][j]=='O'){
                        dfs(i,j,board,directions);
                    }
                }
            }
        }

        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[i].length ; j++) {
                if (board[i][j]=='O'){
                    board[i][j]='X';
                }else if (board[i][j]=='A'){
                    board[i][j]='O';
                }
            }
        }
    }
    static void dfs(int row,int col,char[][]board,List<int[]>directions){
        if (isvalid(row,col,board)){
            board[row][col]='A';
            for (int i = 0; i <directions.size() ; i++) {
                dfs(row+directions.get(i)[0],col+directions.get(i)[1],board,directions);
            }
        }else return;
    }
    static boolean isvalid(int row,int col,char[][]board){
        return row>=0&&row<board.length&&col>=0&&col<board[0].length&&board[row][col]=='O';
    }
}

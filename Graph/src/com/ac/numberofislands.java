package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class numberofislands {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int row=sc.nextInt();
        int col=sc.nextInt();
        char[][]grid=new char[row][col];
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                grid[i][j]=sc.next().charAt(0);
            }
        }
        System.out.println(numIslands(grid));
    }
    static int numIslands(char[][]grid){
        int cnt=0;
        List<int[]>directions=new ArrayList<>();
        directions.add(new int[]{1,0});
        directions.add(new int[]{-1,0});
        directions.add(new int[]{0,1});
        directions.add(new int[]{0,-1});
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[i].length ; j++) {
                if (grid[i][j]=='1'){
                    cnt++;
                    dfs(i,j,directions,grid);
                }
            }
        }
        return cnt;
    }
    static void dfs(int row,int col,List<int[]>directions,char[][]grid){
        if (!isvalid(row,col,grid,grid.length,grid[0].length))return;
        grid[row][col]='0';
        for (int i = 0; i <directions.size() ; i++) {
            dfs(row+directions.get(i)[0],col+directions.get(i)[1],directions,grid);
        }
    }
    static boolean isvalid(int row,int col,char[][]grid,int rowlimit,int collimit){
        return row>=0&&row<rowlimit&&col>=0&&col<collimit&&grid[row][col]=='1';
    }
}

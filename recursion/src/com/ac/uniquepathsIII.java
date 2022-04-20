package com.ac;

public class uniquepathsIII {
    public static void main(String[] args) {
        int[][]grid={{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        System.out.println(uniquePaths(grid));
    }
    public static int uniquePaths(int[][] grid) {
        int count = 0;
        int[][] isvisited = new int[grid.length][grid[0].length];
        int x=0, y=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    count++;
                }else if (grid[i][j]==0||grid[i][j]==2){
                    count++;
                }
            }
        }
        return count(grid,x,y,isvisited,0,count);
    }
    static int count(int[][]arr,int i,int j,int[][]isvisited,int covered,int count){
        if (arr[i][j]==2) {
            covered++;
            if (covered == count) {
                return 1;
            }
            return 0;
        }
        isvisited[i][j]=1;
        covered++;
        int sum=0;
        if ((issafe(arr,i,j+1))&&(isvisited[i][j+1]!=1)){
            sum+=count(arr,i,j+1,isvisited,covered,count);
        }
        if ((issafe(arr,i,j-1))&&(isvisited[i][j-1]!=1)){
            sum+=count(arr, i, j-1, isvisited, covered, count);
        }
        if ((issafe(arr,i-1,j))&&(isvisited[i-1][j]!=1)){
            sum+=count(arr, i-1, j, isvisited, covered, count);
        }
        if ((issafe(arr,i+1, j))&&(isvisited[i+1][j]!=1)){
            sum+=count(arr, i+1, j, isvisited, covered, count);
        }
        isvisited[i][j]=0;
        return sum;
    }
    static boolean issafe(int[][]arr,int i,int j){
        if ((i<arr.length&&i>=0)&&(j<arr[i].length&&j>=0)&&(arr[i][j]!=-1)){
            return true;
        }
        return false;
    }
}

package com.ac;
//////WRONGGGG NOT CORRECT
public class uniquepathsII63 {
    public static void main(String[] args) {
       int[][]obstaclegrid={{0,0,0,0},{0,1,0,0},{0,0,0,0},{0,0,1,0},{0,0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstaclegrid));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0]==1)return 0;
        if (obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1)return 0;
        if (obstacleGrid.length==1)return 1;
      obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]=2;
      int[][]isvisited=new int[obstacleGrid.length][obstacleGrid[0].length];
      return count(obstacleGrid,0,0,isvisited);
    }
    static int count(int[][]arr,int i,int j,int[][]isvisited){
        if (arr[i][j]==2){
            return 1;
        }
        isvisited[i][j]=1;
        int sum=0;
        if ((issafe(arr, i, j+1))&&(isvisited[i][j+1]!=1)){
            sum+=count(arr, i, j+1, isvisited);
        }
        if ((issafe(arr, i, j-1))&&(isvisited[i][j-1]!=1)){
            sum+=count(arr, i, j-1, isvisited);
        }
        if ((issafe(arr, i+1, j))&&(isvisited[i+1][j]!=1)){
            sum+=count(arr, i+1, j, isvisited);
        }
        if ((issafe(arr, i-1, j))&&(isvisited[i-1][j]!=1)){
            sum+=count(arr, i-1, j, isvisited);
        }
        isvisited[i][j]=0;
        return sum;
    }
    static boolean issafe(int[][]arr,int i,int j){
        if (((i<arr.length)&&(i>=0))&&((j<arr[i].length)&&j>=0)){
            if (arr[i][j]!=1){
                return true;
            }
        }
        return false;
    }
}

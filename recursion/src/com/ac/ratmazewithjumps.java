package com.ac;

import java.util.Arrays;

public class ratmazewithjumps {
    public static void main(String[] args) {
          //int[][]matrx={{2,1,0,0},{3,0,0,1},{0,1,0,1},{0,0,0,1}};
        int[][]matrx={{1,0}};
//        int[][]matrx={{2,1,0,0},{2,0,0,1},{0,1,0,1},
//                {0,0,0,1}};
       int[][]ans1=shortestdistance(matrx);
       for (int[]i:ans1){
           System.out.println(Arrays.toString(i));
       }
    }
    static int[][]shortestdistance(int[][]matrix){
        if (matrix[0][0]==0)return new int[][]{{-1}};
        //if (matrix[matrix.length-1][matrix.length-1]==0)return new int[][]{{-1}};
       // int[][]ans=new int[matrix.length][matrix.length];
        int[][]isvisited=new int[matrix.length][matrix[0].length];
        reachpath(matrix,0,0,isvisited);
        if (pathreached!=1)return new int[][]{{-1}};
        if (pathreached==1&&(isvisited[0].length==1||isvisited.length==1))return new int[][]{{1}};

        return isvisited;
    }
    static int pathreached=0;
    static void reachpath(int[][]maze,int i,int j,int[][]isvisted){
        if (i==maze.length-1&&j==maze[i].length-1){
            isvisted[i][j]=1;
            pathreached=1;
            return;
        }
        isvisted[i][j]=1;
        for (int k = 0; k <maze[i][j] ; k++) {
            if (issafe(maze,i,j+1+k)&&(isvisted[i][j+1+k]!=1)&&(pathreached!=1)){
                reachpath(maze,i,j+1+k,isvisted);
            }
            if (issafe(maze,i+1+k,j)&&(isvisted[i+1+k][j]!=1)&&(pathreached!=1)){
                reachpath(maze,i+1+k,j,isvisted);

            }
        }
        if (pathreached!=1) isvisted[i][j]=0;
    }
    static boolean issafe(int[][]arr,int i,int j){
        if ((i<arr.length&&i>=0)&&(j<arr[i].length&&j>=0)){
            if(i==arr.length-1&&j==arr[i].length-1)return true;
            if (arr[i][j]!=0)return true;
        }
        return false;
    }
}

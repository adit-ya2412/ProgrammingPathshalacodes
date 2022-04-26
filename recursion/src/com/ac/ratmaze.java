package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ratmaze {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t!=0){
            int n=sc.nextInt();
            int [][]maze=new int[n][n];
            for (int i = 0; i <maze.length ; i++) {
                for (int j = 0; j <maze[i].length ; j++) {
                    maze[i][j]=sc.nextInt();
                }
            }
            List<List<String>>ans=new ArrayList<>();
            //List<String>path=new ArrayList<>();
              if (maze[0][0]==0) System.out.println(ans);
              else if (maze[n-1][n-1]==0) System.out.println(ans);
              else {
                  int[][]isvisted=new int[n][n];
                  safetrack(maze,0,0,isvisted,new ArrayList<>(),ans);
                  for (int i=0;i<ans.size();i++){
                      for (int j=0;j<ans.get(i).size();j++){
                          System.out.print(ans.get(i).get(j)+"");
                      }
                      System.out.println();
                  }
              }
              t--;
        }

    }
    static void safetrack(int[][]maze, int i, int j, int[][]isvisited, List<String>path,List<List<String>>paths){
        if (i== maze.length-1&&j==maze[i].length-1){
            paths.add(new ArrayList<>(path));
            return;
        }
        isvisited[i][j]=1;
        if (issafe(maze,i+1,j)&&(isvisited[i+1][j]!=1)){
            path.add("D");
            safetrack(maze,i+1,j,isvisited,path,paths);
            path.remove(path.size()-1);
        }
        if (issafe(maze,i,j-1)&&(isvisited[i][j-1]!=1)){
            path.add("L");
            safetrack(maze,i,j-1,isvisited,path,paths);
            path.remove(path.size()-1);
        }
        if (issafe(maze,i,j+1)&&(isvisited[i][j+1]!=1)){
            path.add("R");
            safetrack(maze,i,j+1,isvisited,path,paths);
            path.remove(path.size()-1);
        }
        if (issafe(maze,i-1,j)&&(isvisited[i-1][j]!=1)){
            path.add("U");
            safetrack(maze,i-1,j,isvisited,path,paths);
            path.remove(path.size()-1);
        }
        isvisited[i][j]=0;
    }
    static boolean issafe(int[][]maze,int i,int j){
        if ((i<maze.length&&i>=0)&&(j<maze[i].length&&j>=0)){
            if (maze[i][j]==1)return true;
        }
        return false;
    }

}

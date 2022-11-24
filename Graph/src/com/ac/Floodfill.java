package com.ac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Floodfill {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][]image=new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                image[i][j]=sc.nextInt();
            }
        }
        int sr=sc.nextInt();
        int src=sc.nextInt();
        int newColor=sc.nextInt();
        int[][]ans=floodFill(image,sr,src,newColor);
        for (int[]a:ans){
            System.out.println(Arrays.toString(a));
        }
    }
    static int[][]floodFill(int[][]image,int sr,int sc,int newColor){
        List<int[]> directions=new ArrayList<>();
        directions.add(new int[]{1,0});
        directions.add(new int[]{-1,0});
        directions.add(new int[]{0,1});
        directions.add(new int[]{0,-1});
        int[][]visited=new int[image.length][image[0].length];
        int prevcolor=image[sr][sc];
        dfs(image,sr,sc,directions,prevcolor,newColor,visited);
        return image;
    }
    static void dfs(int[][]image,int row,int col,List<int[]>directions,int prevcolor,int newColor,int[][]visited){
        if (isvalid(image,row,col)&&visited[row][col]!=1){
            if (image[row][col]==prevcolor){
                image[row][col]=newColor;
                visited[row][col]=1;
                for (int i = 0; i <directions.size() ; i++) {
                    int x=row+directions.get(i)[0];
                    int y=col+directions.get(i)[1];
                    dfs(image,x,y,directions,prevcolor,newColor,visited);
                }
            }
        }
    }
    static boolean isvalid(int [][]image,int row,int col){
        return row>=0&&row< image.length&&col>=0&&col< image[0].length;
    }
}

package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PacificAtlanticwaterflow {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][]heights=new int[m][n];
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                heights[i][j]=sc.nextInt();
            }
        }
        List<List<Integer>>ans=pacificAtlantic(heights);
        for (List<Integer>a:ans){
            System.out.println(a);
        }
    }
    static List<List<Integer>>pacificAtlantic(int[][]heights){
        int[][]pacific=new int[heights.length][heights[0].length];
        int[][]atlantic=new int[heights.length][heights[0].length];
        List<int[]>directions=new ArrayList<>();
        directions.add(new int[]{1,0});
        directions.add(new int[]{-1,0});
        directions.add(new int[]{0,1});
        directions.add(new int[]{0,-1});
        for (int i = 0; i <heights.length ; i++) {
            dfs(heights,i,0,pacific,directions,heights[i][0]);
            dfs(heights,i,heights[i].length-1,atlantic,directions,heights[i][heights[i].length-1]);
        }
        for (int i = 0; i <heights[0].length ; i++) {
          dfs(heights,0,i,pacific,directions,heights[0][i]);
          dfs(heights,heights.length-1,i,atlantic,directions,heights[heights.length-1][i]);
        }
        List<List<Integer>>ans=new ArrayList<>();
        for (int i = 0; i <heights.length ; i++) {
            for (int j = 0; j <heights[i].length ; j++) {
                if (atlantic[i][j]==1&&pacific[i][j]==1){
                    List<Integer>temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
    static void dfs(int[][]heights,int x,int y,int[][]visited,List<int[]>directions,int currheight){
        if (visited[x][y]==1)return;
        visited[x][y]=1;
        for (int i = 0; i <directions.size(); i++) {
            if (isvalid(x+directions.get(i)[0],y+directions.get(i)[1],heights,currheight)){
                dfs(heights,x+directions.get(i)[0],y+directions.get(i)[1],visited,directions,heights[x+directions.get(i)[0]][y+directions.get(i)[1]]);
            }
        }
    }
    static boolean isvalid(int x,int y,int[][]heights,int currheight){
        return x>=0&&x<heights.length&&y>=0&&y<heights[x].length&&(heights[x][y]>=currheight);
    }
}

package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Foxandtwodots {
    static boolean cycle;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]inputs=(br.readLine().trim()).split("\\s+");
        int n=Integer.parseInt(inputs[0]);
        int m=Integer.parseInt(inputs[1]);
        char[][]grid=new char[n][m];
        String s;
        for (int i = 0; i <n ; i++) {
            s=(br.readLine().trim());
            for (int j = 0; j <m ; j++) {
                grid[i][j]=s.charAt(j);
            }
        }
        List<int[]> directions=new ArrayList<>();
        directions.add(new int[]{1,0});
        directions.add(new int[]{-1,0});
        directions.add(new int[]{0,1});
        directions.add(new int[]{0,-1});
        int[][]visited=new int[n][m];
        cycle=false;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m; j++) {
                if (visited[i][j]==0){
                    dfs(grid,i,j,grid[i][j],directions,i,j,visited);
                }
                if (cycle)break;
            }
        }
        if (cycle) System.out.println("Yes");
        else System.out.println("No");
    }
    static void dfs(char[][]grid,int x,int y,char curr,List<int[]>directions,int prevx,int prevy,int[][]visited){
        if (isvalid(grid,x,y,curr)){
            if (visited[x][y]==1){
                cycle=true;
                return;
            }
            visited[x][y]=1;
            for (int i = 0; i <directions.size() ; i++) {
                if (x+directions.get(i)[0]==prevx&&y+directions.get(i)[1]==prevy)continue;
                dfs(grid,x+directions.get(i)[0],y+directions.get(i)[1],curr,directions,x,y,visited);
            }
        }
    }
    static boolean isvalid(char[][]grid,int x,int y,int curr){
        return x>=0&&x<grid.length&&y>=0&&y<grid[x].length&&grid[x][y]==curr;
    }
}

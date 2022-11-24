package com.ac;
import java.io.*;
import java.util.*;

public class Validatethemaze {
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        List<int[]>directions=new ArrayList<>();
        directions.add(new int[]{1,0});
        directions.add(new int[]{-1,0});
        directions.add(new int[]{0,1});
        directions.add(new int[]{0,-1});
        while (t!=0){
            String[] inputs = (br.readLine().trim()).split("\\s+");
            char[][] maze = new char[Integer.parseInt(inputs[0])][Integer.parseInt(inputs[1])];
            String s;
            for (int i = 0; i < Integer.parseInt(inputs[0]); i++) {
                s = (br.readLine().trim());
                for (int j = 0; j < Integer.parseInt(inputs[1]); j++) {
                    maze[i][j] = s.charAt(j);
                }
            }
            List<int[]>postions=new ArrayList<>();
            //HashMap<Integer,Boolean>mapy=new HashMap<>();
            findedges(maze,postions);
            if (postions.size()!=2) {
                System.out.println("invalid");
                t--;
                continue;
            }
            flag=false;
            dfs(maze,postions.get(0)[0],postions.get(0)[1],postions.get(1)[0],postions.get(1)[1],directions);
            if (flag) System.out.println("valid");
            else System.out.println("invalid");
            t--;
        }
    }
    static void dfs(char[][]grid,int x,int y,int targx,int targy,List<int[]>directions){
        if (isvalid(grid,x,y)){
            if (x==targx&&y==targy){
                flag=true;
                return;
            }
            grid[x][y]='0';
            for (int i = 0; i <directions.size() ; i++) {
                dfs(grid,x+directions.get(i)[0],y+directions.get(i)[1],targx,targy,directions);
            }
        }
    }
    static boolean isvalid(char[][]grid,int x,int y){
        return x>=0&&x<grid.length&&y>=0&&y<grid[x].length&&(grid[x][y]=='.');
    }

    static void findedges(char[][] maze, List<int[]> postitons) {
        //for row1 and col1 and lastcolumn
        for (int i = 0; i < maze.length; i++) {
            if (maze[i][0] == '.') {
                postitons.add(new int[]{i, 0});
            }
            if (maze[0].length > 1) {
                if (maze[i][maze[i].length - 1] == '.') {
                    postitons.add(new int[]{i, maze[i].length - 1});
                }
            }
        }
            for (int j = 1; j < maze[0].length - 1; j++) {
                if (maze[0][j] == '.') {
                    postitons.add(new int[]{0, j});
                }
                if(maze.length>1){
                    if(maze[maze.length-1][j]=='.'){
                        postitons.add(new int[]{maze.length-1,j});
                    }
                }
            }
    }
}


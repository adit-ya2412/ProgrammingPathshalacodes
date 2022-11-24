package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class minesweeper {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int m=Integer.parseInt(br.readLine().trim());
        int n=Integer.parseInt(br.readLine().trim());
        char[][]board=new char[m][n];
        String s;
        for (int i = 0; i <m ; i++) {
            s=(br.readLine());
            for (int j = 0; j <n ; j++) {
                board[i][j]=s.charAt(j);
            }
        }
        String[]inputs=(br.readLine().trim()).split("\\s+");
        int[]click={Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1])};
        char[][]ans=updateBoard(board,click);
    }
    static char[][] updateBoard(char[][]board,int[]click){
        List<int[]>directions=new ArrayList<>();
        directions.add(new int[]{1,0});
        directions.add(new int[]{-1,0});
        directions.add(new int[]{0,1});
        directions.add(new int[]{0,-1});
        directions.add(new int[]{1,1});
        directions.add(new int[]{-1,1});
        directions.add(new int[]{1,-1});
        directions.add(new int[]{-1,-1});
        dfs(board,click[0],click[1],directions);
        return board;
    }
    static void dfs(char[][]board,int x,int y,List<int[]>directions){
        if (board[x][y]=='M'){
            board[x][y]='X';
            return;
        }else {
            int count=0;
            for (int i = 0; i <directions.size() ; i++) {
                if(isvalid(board,x+directions.get(i)[0],y+directions.get(i)[1])){
                    int tempx=x+directions.get(i)[0];
                    int tempy=y+directions.get(i)[1];
                    if (board[tempx][tempy]=='M'||board[tempx][tempy]=='X')count++;
                }
            }
            if (count>0){
                board[x][y]=(char) (count+'0');
            }else {
                board[x][y]='B';
                for (int i = 0; i <directions.size() ; i++) {
                    if (isvalid(board,directions.get(i)[0],directions.get(i)[1])){
                        int tempx=x+directions.get(i)[0];
                        int tempy=y+directions.get(i)[1];
                        if (board[tempx][tempy]=='E'){
                            dfs(board,tempx,tempy,directions);
                        }
                    }
                }
            }
        }
    }
    static boolean isvalid(char[][]board,int x,int y){

        return x>=0&&x<board.length&&y>=0&&y<board.length;
    }
}

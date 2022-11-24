package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BiridianForest {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]dimensions=(br.readLine().trim()).split("\\s+");

        int rows=Integer.parseInt(dimensions[0]);
        int cols=Integer.parseInt(dimensions[1]);
        char[][]board=new char[rows][cols];
        int[]end=new int[2];
        int[]start=new int[2];
        for (int i = 0; i <rows ; i++) {
             String inputs=(br.readLine().trim());
            for (int j = 0; j <cols ; j++) {
                board[i][j]=inputs.charAt(j);
                if (inputs.charAt(j)=='S'){
                    start[0]=i;
                    start[1]=j;
                }
                if (inputs.charAt(j)=='E'){
                    end[0]=i;
                    end[1]=j;
                }

            }
        }
        System.out.println(findminpath(board,start,end));

    }
    static int findminpath(char[][]board,int[]start,int[]end){
        List<int[]>directions=new ArrayList<>();
        directions.add(new int[]{1,0});
        directions.add(new int[]{-1,0});
        directions.add(new int[]{0,1});
        directions.add(new int[]{0,-1});
        int ans=0;
        int[][]visited=new int[board.length][board[0].length];
        Queue<int[]>queue=new LinkedList<>();
        queue.add(end);
        visited[end[0]][end[1]]=1;
        int[]temp;
        boolean flg=false;
        while (!queue.isEmpty()){
            int size= queue.size();int breedersfound=0;
            for (int k = 0; k <size ; k++) {
                temp=queue.poll();
                if (temp[0]==start[0]&&temp[1]==start[1])return ans;
                for (int i = 0; i <directions.size() ; i++) {
                    if (isvalid(temp[0]+directions.get(i)[0],temp[1]+directions.get(i)[1],board)&&visited[temp[0]+directions.get(i)[0]][temp[1]+directions.get(i)[1]]==0){
                        char c=board[temp[0]+directions.get(i)[0]][temp[1]+directions.get(i)[1]];
                        if (c!='S'){
                            int x=c-'0';
                            breedersfound+=x;
                        }
                        visited[temp[0]+directions.get(i)[0]][temp[1]+directions.get(i)[1]]=1;
                        queue.add(new int[]{temp[0]+directions.get(i)[0],temp[1]+directions.get(i)[1]});


                    }
                }
            }
            ans+=breedersfound;
        }
     return ans;
    }
    static boolean isvalid(int row,int col,char[][]board){
        return row>=0&&row<board.length&&col>=0&&col<board[0].length&&board[row][col]!='T';
    }
}

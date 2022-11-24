package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerialTime {
    static int count;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]inputs=(br.readLine().trim()).split("\\s+");
        int k=Integer.parseInt(inputs[0]);
        int n=Integer.parseInt(inputs[1]);
        int m=Integer.parseInt(inputs[2]);
        String s;
        char[][][]rectangele=new char[k][n][m];
        for (int i = 0; i < k; i++) {
            br.readLine();
            for (int j = 0; j <n ; j++) {
                s=br.readLine().trim();
                for (int l = 0; l <m ; l++) {
                    rectangele[i][j][l]=s.charAt(l);
                }
            }
        }

        br.readLine();
        inputs=(br.readLine().trim()).split("\\s+");
        int st=Integer.parseInt(inputs[0])-1;
        int end=Integer.parseInt(inputs[1])-1;
        count=0;
        List<int[]>directions=new ArrayList<>();
        //List<int[]>directions=new ArrayList<>();
        directions.add(new int[]{1,0,0});
        directions.add(new int[]{-1,0,0});
        directions.add(new int[]{0,1,0});
        directions.add(new int[]{0,-1,0});
        directions.add(new int[]{0,0,1});
        directions.add(new int[]{0,0,-1});

        dfs(rectangele,0,st,end,directions);

        System.out.println(count);
    }
    static void dfs(char[][][]rectangle,int k,int st,int end,List<int[]>directions){
        if (isvalid(rectangle,k,st,end)){
            rectangle[k][st][end]='0';
            count++;
            int l,x,y;
            l=k;
            x=st;
            y=end;
            for (int i = 0; i <directions.size() ; i++) {
                dfs(rectangle,l+directions.get(i)[0],x+directions.get(i)[1],y+directions.get(i)[2],directions);
            }
        }
    }
    static boolean isvalid(char[][][]rectangle,int level,int x,int y){
        return level>=0&&level< rectangle.length&&x>=0&&x<rectangle[0].length&&y>=0&&y<rectangle[0][0].length&&(rectangle[level][x][y]!='#'&&rectangle[level][x][y]!='0');
    }
}

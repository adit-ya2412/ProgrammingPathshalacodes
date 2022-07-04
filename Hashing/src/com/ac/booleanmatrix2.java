package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class booleanmatrix2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int turnedon=Integer.parseInt(br.readLine().trim());
        int[][]lamps=new int[turnedon][2];
        for (int i = 0; i <turnedon ; i++) {
            String[]on=(br.readLine().trim()).split("\\s+");
            lamps[i][0]=Integer.parseInt(on[0]);
            lamps[i][1]=Integer.parseInt(on[1]);
        }
        int query=Integer.parseInt(br.readLine().trim());
        int[][]queries=new int[query][2];
        for (int i = 0; i <query ; i++) {
            String[]ifo=(br.readLine().trim()).split("\\s+");
            queries[i][0]=Integer.parseInt(ifo[0]);
            queries[i][1]=Integer.parseInt(ifo[1]);
        }
        System.out.println(Arrays.toString(gridIllumination(n,lamps,queries)));

        
    }
    static int[]gridIllumination(int n,int[][]lamps,int[][]queries){
        int[]mazordiagonal=new int[2*n];
        int[]minordiagonal=new int[2*n];
        int[]rows=new int[n];
        int[]column=new int[n];
        int r,c;
        for (int i=0;i< lamps.length;i++){
            r=lamps[i][0];
            c=lamps[i][1];
            mazordiagonal[(r-c)+(n-1)]=1;
            minordiagonal[r+c]=1;
            rows[r]=1;
            column[c]=1;
        }
        int[]ans=new int[queries.length];
        for (int i = 0; i < queries.length ; i++) {
            r=queries[i][0];
            c=queries[i][1];
            if (rows[r]==1||column[c]==1||mazordiagonal[(r-c)+(n-1)]==1||mazordiagonal[r+c]==1){
                ans[i]=1;
                rows[r]=0;
                column[c]=0;
                mazordiagonal[(r-c)+(n-1)]=0;
                minordiagonal[r+c]=0;
            }
        }
        return ans;
    }
}

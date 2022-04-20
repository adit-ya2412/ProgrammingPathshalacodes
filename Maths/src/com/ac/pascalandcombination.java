package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class pascalandcombination {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        int test = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        long[][] pascal = createarray(60);
        for(int k = 1;k<=test;k++){

            String line = br.readLine();

            String[] input = line.trim().split("\\s+");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int t = Integer.parseInt(input[2]);

            long ans = 0;
            ans += pascal[n + m][t];
            if (t<=m){
                ans-=(pascal[n][0]*pascal[m][t]);
            } if (t-1<=m){
                ans-=(pascal[n][1]*pascal[m][t-1]);
            } if (t-2<=m){
                ans-=(pascal[n][2]*pascal[m][t-2]);
            } if (t-3<=m){
                ans-=(pascal[n][3]*pascal[m][t-3]);
            } if (t<=n){
                  ans-=(pascal[n][t]);
            }
            System.out.println(ans);
        }
    }

    static long[][]createarray(int n){
        long[][]arr=new long[n+1][n+1];
        arr[0][0]=1;
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <=i ; j++) {
               if (j==i||j==0){
                   arr[i][j]=1;
               }else {
                   arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
               }
            }
        }
        return arr;
    }
}

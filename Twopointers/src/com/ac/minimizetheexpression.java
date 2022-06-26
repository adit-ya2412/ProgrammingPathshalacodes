package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class minimizetheexpression {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]a=new int[n];
        int[]b=new int[n];
        int[]c=new int[n];
        String[]ele1=(in.readLine().trim()).split("\\s+");
        String[]ele2=(in.readLine().trim()).split("\\s+");
        String[]ele3=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            a[i]=Integer.parseInt(ele1[i]);
            b[i]=Integer.parseInt(ele2[i]);
            c[i]=Integer.parseInt(ele3[i]);
        }

        printmini(a,b,c);
    }
    static void printmini(int[]a,int []b,int[]c){
        int i=0,j=0,k=0;
        int ans=Integer.MAX_VALUE;
        while (i<a.length&&j<b.length&&k<c.length){
            int val=Math.max(Math.max(a[i],b[j]),c[k])-Math.min(Math.min(a[i],b[j]),c[k]);
            ans=Math.min(ans,val);
            int minm=Math.min(Math.min(a[i],b[j]),c[k]);
            if (a[i]==minm)i++;
            else if (b[j]==minm)j++;
            else k++;
        }
        System.out.println(ans);
    }
}

package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class solvetheequation {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int a=Integer.parseInt(in.readLine().trim());
        int b=Integer.parseInt(in.readLine().trim());
        int c=Integer.parseInt(in.readLine().trim());
        int n=Integer.parseInt(in.readLine().trim());
        long[]arr=new long[n];
        String[]elements=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Long.parseLong(elements[i]);
        }
        long []answer=sortarray(arr,n,a,b,c);
        System.out.println(Arrays.toString(answer));

    }
    static long[]sortarray(long[]arr,int n,int A,int B,int C){
     long[]ans=new long[arr.length];
     if (A>=0){
         int st=0;
         int end=n-1;
         int pos=n-1;
         while (st<=end){
             long point1=(A*(arr[st]*arr[st])+(B*arr[st])+C);
             long point2=(A*(arr[end]*arr[end])+(B*arr[end])+C);
             if (point2>=point1){
                 ans[pos]=point2;
                 end--;
             }else {
                 ans[pos]=point1;
                 st++;
             }
             pos--;
         }
     }else {
         int st=0;
         int end=n-1;
         int pos=0;
         while (st<=end){
             long point1=(A*(arr[st]*arr[st])+(B*arr[st])+C);
             long point2=(A*(arr[end]*arr[end])+(B*arr[end])+C);
             if (point1<=point2){
                 ans[pos]=point1;
                 st++;
             }else {
                 ans[pos]=point2;
                 end--;
             }
             pos++;
         }
     }
     return ans;
    }
}

package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class firstnegativeinwindow {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[]arr=new int[n];
        String[]ell=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ell[i]);
        }
        int k=Integer.parseInt(br.readLine().trim());
        System.out.println(Arrays.toString(negative(arr,k)));
    }
    static int[]negative(int[]arr,int k){
        int[]ans=new int[arr.length-k+1];
        Queue<Integer>q=new LinkedList<>();
        for (int i = 0; i <k ; i++) {
            if (arr[i]<0)q.add(i);
        }
        for (int i = k; i < arr.length ; i++) {
            if (q.isEmpty())ans[i-k]=0;
            else {
                ans[i-k]= arr[q.peek()];
            if (q.peek()==i-k)q.remove();}
            if (arr[i]<0)q.add(i);
        }
        if (q.isEmpty()){
            ans[arr.length-k]=0;
        }else {
            ans[arr.length-k]=arr[q.peek()];
        }
        return ans;
    }
}

package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class find132pattern {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[]arr=new int[n];
        String[]input=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(input[i]);
        }
        System.out.println(check(arr));
    }
    static boolean check(int[]arr){
        Stack<Integer>small=new Stack<>();
        int[]pge=new int[arr.length];
        int[]pse=new int[arr.length];
        small.push(arr.length-1);
        for (int i =arr.length-2; i >=0 ; i--) {
            while (!small.isEmpty()&&arr[small.peek()]<arr[i]){
               pge[small.peek()]=i;
               small.pop();
            }
            small.push(i);
        }
        while (!small.isEmpty()){
            pge[small.peek()]=-1;
            small.pop();
        }
        pse[0]=arr[0];
        for (int i = 1; i < arr.length ; i++) {
            pse[i]=Math.min(pse[i-1],arr[i] );
        }

        for (int i = 0; i < arr.length ; i++) {
            if (pge[i]!=-1){
                {
                    if (arr[i]>pse[pge[i]])return true;
                }
            }
        }
        return false;
    }
}

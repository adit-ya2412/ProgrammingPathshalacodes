package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BinaryMatrix1 {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]inputs=(br.readLine().trim()).split("\\s+");
        int m=Integer.parseInt(inputs[0]);
        int n=Integer.parseInt(inputs[1]);
        int[][]arr=new int[m][n];
        for (int i = 0; i <m ; i++) {
           String[]inpu=(br.readLine().trim()).split("\\s+");
            for (int j = 0; j <n ; j++) {
                arr[i][j]=Integer.parseInt(inpu[j]);
            }
        }
        int base=m-1;
        System.out.println(largestRectangle(arr,base));

    }
    static int largestRectangle(int[][]arr,int base){
        int cnt=0;
        for (int i =0; i<arr[0].length ; i++) {
            cnt=0;
            for (int j =base ; j >=0 ; j--) {
                if (arr[j][i]==1){
                    cnt++;
                }else {
                    break;
                }
            }
            arr[base][i]=cnt;
        }
        int []nextsmallerelement=new int[arr[0].length];
        int []prevsmallerelement=new int[arr[0].length];
        Stack<Integer>sta=new Stack<>();
        sta.push(0);
        for (int i = 1; i <arr[base].length ; i++) {
            while (!sta.empty()&&(arr[base][sta.peek()]>arr[base][i])){
                nextsmallerelement[sta.peek()]=i;
                sta.pop();
            }
            sta.push(i);
        }
        while (!sta.empty()){
            nextsmallerelement[sta.peek()]=arr[base].length;
            sta.pop();
        }
        sta.push(arr[base].length-1);
        for (int i =arr[base].length-2; i>=0 ; i--) {
            while (!sta.empty()&&(arr[base][sta.peek()]>arr[base][i])){
                prevsmallerelement[sta.peek()]=i;
                sta.pop();
            }
            sta.push(i);
        }
        while (!sta.empty()){
            prevsmallerelement[sta.peek()]=-1;
            sta.pop();
        }
        int max=0;
        int ht;
        for (int i = 0; i <arr[base].length ; i++) {
            ht=arr[base][i];
            max=Math.max(max,ht*(nextsmallerelement[i]-prevsmallerelement[i]-1));
        }
        return max;
    }
}

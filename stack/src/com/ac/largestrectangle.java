package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class largestrectangle {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[]arr=new int[n];
        String[]heights=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(heights[i]);
        }
        System.out.println(largestrectangleArea(arr));

    }
    static int largestrectangleArea(int[]heights){
        int[]nextsmaller=new int[heights.length];
        int[]prevsmaller=new int[heights.length];
        Stack<Integer>smallest=new Stack<>();
        smallest.push(0);
        for (int i = 1; i <heights.length ; i++) {
            while (!smallest.empty()&&heights[i]<heights[smallest.peek()]){
                nextsmaller[smallest.peek()]=i;
                smallest.pop();
            }
            smallest.push(i);
        }
        while (!smallest.empty()){
            nextsmaller[smallest.peek()]=heights.length;
            smallest.pop();
        }
        smallest.push(heights.length-1);
        for (int i = heights.length-2; i >=0 ; i--) {
            while (!smallest.empty()&&heights[i]<heights[smallest.peek()]){
                prevsmaller[smallest.peek()]=i;
                smallest.pop();
            }
            smallest.push(i);
        }
        while (!smallest.empty()){
            prevsmaller[smallest.peek()]=-1;
            smallest.pop();
        }
        int ans=Integer.MIN_VALUE;
        for (int i = 0; i < heights.length ; i++) {
            ans=Math.max(ans,(heights[i]*(nextsmaller[i]-prevsmaller[i]-1)));
        }
        return ans;

    }
}

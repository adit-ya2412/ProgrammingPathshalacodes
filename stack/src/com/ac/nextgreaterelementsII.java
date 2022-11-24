package com.ac;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class nextgreaterelementsII {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }
    static int[] nextGreaterElements(int[]nums) {
        if (nums.length == 1) return new int[]{-1};
        int[] nextgreater = new int[nums.length];
        Arrays.fill(nextgreater,-1);
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < nums.length; i++) {
            while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
                nextgreater[st.pop()] = nums[i];
            }
            st.push(i);
        }
        for (int i =0; i < nums.length ; i++) {
            while (!st.isEmpty()&&nums[i]>nums[st.peek()]){
                nextgreater[st.pop()]=nums[i];
            }
            st.push(i);
        }
        return nextgreater;
    }
}

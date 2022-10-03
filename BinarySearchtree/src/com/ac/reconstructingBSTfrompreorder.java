package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class reconstructingBSTfrompreorder {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[]arr=new int[n];
        String[]input=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(input[i]);
        }
        TreeNode ans=bstfromPreorder(arr);
    }
    static TreeNode bstfromPreorder(int[]arr){
        if (arr.length==0)return null;
        int[]nge=new int[arr.length];
        Stack<Integer>st=new Stack<>();
        st.push(0);
        for (int i = 1; i <arr.length ; i++) {
            while (!st.isEmpty()&&arr[st.peek()]<arr[i]){
                nge[st.pop()]=i;
            }
            st.push(i);
        }
        while (!st.isEmpty()){
            nge[st.pop()]= arr.length;
        }
        return create(arr,nge,0,arr.length-1);
    }
    static TreeNode create(int[]arr,int[] nge,int st,int end){
        if (st>end)return null;
        TreeNode root=new TreeNode(arr[st]);
        root.left=create(arr,nge,st+1,nge[st]-1);
        root.right=create(arr,nge,nge[st]+1,end);
        return root;
    }
    static int idx=0;
    static TreeNode createbst(int[]preorder){
        return traverse(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    static TreeNode traverse(int[]preorder,int lb,int ub){
        if (idx< preorder.length&&(preorder[idx]>lb&&preorder[idx]<ub)){
            TreeNode root=new TreeNode(preorder[idx]);
            idx++;
            root.left=traverse(preorder,lb,root.val);
            root.right=traverse(preorder, root.val, ub);
            return root;

        }
        return null;
    }
}

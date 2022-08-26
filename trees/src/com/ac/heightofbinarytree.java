package com.ac;

import java.util.Scanner;

public class heightofbinarytree {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
    }
    static int maxlength(TreeNode root){
        if(root==null)return 0;
        int lh=maxlength(root.left);
        int rh=maxlength(root.right);
        return 1+Math.max(lh,rh);
    }
    static  int ans;
    static void getnode(TreeNode root,int l){
        if (root==null)return;
        if (root.left==null&&root.right==null){
            ans=Math.max(ans,l);
            return;
        }
        getnode(root.left,l+1);
        getnode(root.right,l+1);
    }

}

package com.ac;

import java.util.Scanner;

public class sumofleftnodes {
    public static void main(String[] args) {
        TreeNode root;
        TreeNode temp=new TreeNode(3);
        temp.left=new TreeNode(9);
        temp.right=new TreeNode(20);
        root=temp;
        temp=temp.right;
        temp.left=new TreeNode(15);
        temp.right= new TreeNode(7);
        System.out.println(sum(root));
    }
    static int sum(TreeNode root){
        if (root==null)return 0;
        if (root.left==null&&root.right==null)return 0;
        return s(root.left,true)+s(root.right,false);

    }
    static int s(TreeNode root,boolean isleft){
        if (root==null)return 0;
        if (root!=null&&isleft==true &&(root.left==null&&root.right==null))return root.val;
        return s(root.left,true)+s(root.right.left,false);
    }
}


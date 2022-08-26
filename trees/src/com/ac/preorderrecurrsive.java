package com.ac;

public class preorderrecurrsive {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(3);
        root.right=new TreeNode(7);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(5);
        root.left.right.right=new TreeNode(6);
        root.right.left=new TreeNode(9);
        root.right.right=new TreeNode(10);
        preorder(root);
    }
    static void preorder(TreeNode root){
        if (root==null)return;
        System.out.print(root.val+"-->");
        preorder(root.left);
        preorder(root.right);
    }
}

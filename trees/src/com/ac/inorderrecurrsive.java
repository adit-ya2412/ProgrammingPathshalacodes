package com.ac;

public class inorderrecurrsive {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(3);
        root.right=new TreeNode(7);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(5);
        root.left.right.right=new TreeNode(6);
        root.right.left=new TreeNode(9);
        root.right.right=new TreeNode(10);
        inorder(root);

    }
    static void inorder(TreeNode root){
        if (root==null)return;
        inorder(root.left);
        System.out.print(root.val+"-->");
        inorder(root.right);
    }
}

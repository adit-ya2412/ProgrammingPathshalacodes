package com.ac;

public class postorderrecurrsive {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(3);
        root.right=new TreeNode(7);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(5);
        root.left.right.right=new TreeNode(6);
        root.right.left=new TreeNode(9);
        root.right.right=new TreeNode(10);
        postorder(root);
    }
    static void postorder(TreeNode root){
        if (root==null)return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val+"--->");
    }
}

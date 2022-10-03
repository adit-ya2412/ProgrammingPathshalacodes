package com.ac;

public class converttogreaterBSt {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(1);
        root.right=new TreeNode(6);
        root.left.left=new TreeNode(0);
        root.left.right=new TreeNode(2);
        root.left.right.right=new TreeNode(3);
        //root.right=new TreeNode(6);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(7);
        root.right.right.right=new TreeNode(8);
        TreeNode ans=convertBST(root);
         traverse(ans);
    }
    static void traverse(TreeNode root){
        if (root==null)return;
        traverse(root.left);
        System.out.println(root.val);
        traverse(root.right);
    }
    static int currsum=0;
    static TreeNode convertBST(TreeNode root){
        if (root!=null){
            convertBST(root.right);
            currsum+=root.val;
            root.val=currsum;
            convertBST(root.left);
        }
        return root;
    }
}

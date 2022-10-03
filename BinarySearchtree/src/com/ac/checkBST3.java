package com.ac;

public class checkBST3 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(6);
        root.right=new TreeNode(20);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(9);
        root.left.right.left=new TreeNode(7);
        root.right.left=new TreeNode(15);
        System.out.println(check(root));
    }
    static boolean ans=true;
    static boolean check(TreeNode root){
        traverse(root,Long.MIN_VALUE,Long.MAX_VALUE);
        return ans;
    }
    static void traverse(TreeNode root,long lowerbound,long upperbound){
        if (root==null)return;
        if (root.val>lowerbound&&root.val<upperbound){
            traverse(root.left,lowerbound,root.val);
            traverse(root.right,root.val,upperbound);

        }else {
            ans=false;
            return;
        }
    }
}

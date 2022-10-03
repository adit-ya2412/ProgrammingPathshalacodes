package com.ac;

public class checkiftreeisBSTornot {
    public static void main(String[] args) {
//        TreeNode root=new TreeNode(10);
//        root.left=new TreeNode(6);
//        root.right=new TreeNode(20);
//        root.left.left=new TreeNode(4);
//        root.left.right=new TreeNode(9);
//        root.left.right.left=new TreeNode(7);
//        root.right.left=new TreeNode(15);
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(1);
        System.out.println(check(root));
    }
    static boolean ans=true;
    static int prev=Integer.MIN_VALUE;
    static boolean check(TreeNode root){
        traverse(root);
        return ans;
    }
    static void traverse(TreeNode root){
        if (root==null)return;
        traverse(root.left);
        if (root.val>prev){
            prev=root.val;
        }else {
            ans=false;
            return;
        }
        traverse(root.right);
    }
}

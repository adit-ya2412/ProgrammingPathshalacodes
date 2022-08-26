package com.ac;

public class prunebinarytree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(1);
        root.right=new TreeNode(0);
        TreeNode temp=root.left;
        temp.left=new TreeNode(1);
        temp.left.left=new TreeNode(0);
        temp.right=new TreeNode(1);
        temp=root.right;
        temp.left=new TreeNode(0);
        temp.right=new TreeNode(1);
//        TreeNode root=new TreeNode(0);
//        root.right=new TreeNode(0);
//        root.right.left=new TreeNode(0);
//        root.right.right=new TreeNode(0);
        TreeNode ans=prune(root);
        print(ans);


    }
    static void  print(TreeNode root){
        if (root==null)return;
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }
    static TreeNode prune(TreeNode root){

        if(check(root))return root;
        else return null;
    }
    static boolean check(TreeNode root){
        if (root==null)return false;
        boolean p1=check(root.left);
        boolean p2=check(root.right);
        if (p1==false)root.left=null;
        if (p2==false)root.right=null;
        return root.val==1||p1||p2;
    }
}

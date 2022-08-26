package com.ac;

public class Diameterofbinarytree {
    public static void main(String[] args) {
       TreeNode root=new TreeNode(1);
       root.left=new TreeNode(2);
       root.right=new TreeNode(3);
       root.left.left=new TreeNode(4);
       root.left.right=new TreeNode(5);

        System.out.println(getdia(root));
    }
    static int ans=0;
    static int getdia(TreeNode root){
        getht(root);
        return ans-1;
    }
    static int getht(TreeNode root){
        if (root==null)return 0;
        int lh=getht(root.left);
        int rh=getht(root.right);
        ans=Math.max(ans,1+lh+rh);
        return 1+Math.max(lh,rh);
    }
}

package com.ac;

public class deepestsumnodes {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(61);
        root.left=new TreeNode(13);
        root.right=new TreeNode(46);
        root.right.right=new TreeNode(56);
        root.right.right.left=new TreeNode(72);
       // TreeNode root=new TreeNode(6);
//        root.left=new TreeNode(7);
//        root.right=new TreeNode(8);
//        root.left.left=new TreeNode(2);
//        root.left.right=new TreeNode(7);
//        root.left.left.left=new TreeNode(9);
//        root.left.right.left=new TreeNode(1);
//        root.left.right.right=new TreeNode(4);
//        TreeNode temp=root.right;
//        temp.left=new TreeNode(1);
//        temp.right=new TreeNode(3);
//        temp.right.right=new TreeNode(5);
        System.out.println(deepestSum(root));
    }
    static int deepestSum(TreeNode root){
        if (root.left==null&&root.right==null)return root.val;
        int getdeepestleft=getdeep(root.left,2);
        int getdeepestright=getdeep(root.right,2);
        int deepest=Math.max(getdeepestleft,getdeepestright);
        int lfsum= getsum(root.left,deepest,2);
        int rfsum=getsum(root.right,deepest,2);
        return lfsum+rfsum;
    }
    static int getsum(TreeNode root,int level,int currlevel){
        if (root==null)return 0;
        if (currlevel==level)return root.val;
        return getsum(root.left,level,currlevel+1)+getsum(root.right,level,currlevel+1);
    }
    static int getdeep(TreeNode root,int level){
        if (root==null)return level;
        if (root.left==null&&root.right==null)return level;
        int lef=level,ref=level;
        if (root.left!=null)lef=getdeep(root.left,level+1);
        if (root.right!=null)ref=getdeep(root.right,level+1);
        return Math.max(lef,ref);
    }
}

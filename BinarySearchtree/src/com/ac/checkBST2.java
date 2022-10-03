package com.ac;

public class checkBST2 {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(6);
        root.right=new TreeNode(20);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(9);
        root.left.right.left=new TreeNode(7);
        root.right.left=new TreeNode(15);
        System.out.println(checkbst(root));

    }
    static boolean checkbst(TreeNode root){
       triplets ans=check(root);
       return ans.check;
    }
    static triplets check(TreeNode root){
        if (root==null){
            return new triplets(true,Long.MIN_VALUE,Long.MAX_VALUE);
        }
        triplets left=check(root.left);
        triplets right=check(root.right);
        boolean flag=left.check&& right.check&&(left.max<root.val&&root.val<right.min);
        long max=Math.max(Math.max(left.max,right.max),root.val);
        long min=Math.min(Math.min(left.min,right.min),root.val);
        return new triplets(flag,max,min);
    }
}
class  triplets{
    boolean check;
    long max;
    long min;
    triplets(boolean check,long max,long min){
        this.check=check;
        this.max=max;
        this.min=min;
    }
}

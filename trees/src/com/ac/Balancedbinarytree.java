package com.ac;

public class Balancedbinarytree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        System.out.println(checkifbalanced(root));
    }
    static boolean checkifbalanced(TreeNode root){
        if (root==null)return true;
        heightandbalance ans=balance(root);
        return ans.bal;

    }
    static heightandbalance balance(TreeNode root){
        if (root==null)return new heightandbalance(0,true);
        heightandbalance p1=balance(root.left);
        heightandbalance p2=balance(root.right);
        boolean an=p1.bal&& p2.bal&&(Math.abs(p1.ht-p2.ht)<=1);
        int h=1+Math.max(p1.ht,p2.ht);
        return new heightandbalance(h,an);
    }
}
class heightandbalance{
    int ht;
    boolean bal;
    heightandbalance(int ht,boolean bl){
        this.ht=ht;
        this.bal=bl;
    }
}

package com.ac;

public class MaxsumBSTinBT {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(4);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(2);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(2);
        root.right.right=new TreeNode(5);
        root.right.right.left=new TreeNode(4);
        root.right.right.right=new TreeNode(6);
        calculate(root);
        System.out.println(sum);
    }
    static long sum=0;
    static sumquad calculate(TreeNode root){
        if (root==null)return new sumquad(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        sumquad left=calculate(root.left);
        sumquad right=calculate(root.right);
        int min=Math.min(Math.min(left.min,right.min),root.val);
        int max=Math.max(Math.max(left.max,right.max), root.val);
        long su=left.sum+right.sum+ root.val;
        if (left.isbst&&right.isbst&&(root.val> left.max&&root.val< right.min)){
            sum=Math.max(su,sum);
            return new sumquad(true,min,max,su);
        }else {
            return new sumquad(false,min,max,su);
        }
    }
}
class sumquad{
    boolean isbst;
    int min;
    int max;
    long sum;
    sumquad(boolean isbst,int min,int max,long sum){
        this.isbst=isbst;
        this.min=min;
        this.max=max;
        this.sum=sum;
    }
}

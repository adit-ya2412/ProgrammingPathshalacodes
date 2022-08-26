package com.ac;

public class Goodnodes {
    public static void main(String[] args) {
        TreeNode root;
        root=new TreeNode(2);
        root.right=new TreeNode(4);
        root.right.left=new TreeNode(10);
        root.right.right=new TreeNode(8);
        root.right.right.left=new TreeNode(4);
        countgoodnodes(root,root.val);
        System.out.println(cnt);
    }
    static int cnt=1;
    static void countgoodnodes(TreeNode root,int max){
        if (root==null)return;
        int tempmax=max;
        if (root.left!=null){
            if(root.left.val>=tempmax){
                cnt= cnt+1;
                tempmax=root.left.val;
                countgoodnodes(root.left,tempmax);
            }else{
                countgoodnodes(root.left,tempmax);
            }
        }
        tempmax=max;
        if(root.right!=null){
            if(root.right.val>=tempmax){
                cnt=cnt+1;
                tempmax=root.right.val;
                countgoodnodes(root.right,tempmax);
            }else{
                countgoodnodes(root.right,tempmax);
            }
        }
    }

}

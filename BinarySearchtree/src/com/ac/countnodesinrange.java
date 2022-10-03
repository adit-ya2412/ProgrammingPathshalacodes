package com.ac;

public class countnodesinrange {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.right=new TreeNode(50);
        root.left.left=new TreeNode(1);
        root.right.left=new TreeNode(40);
        root.right.right=new TreeNode(100);
        System.out.println(getcount(root,5,45));
    }
    static int getcount(TreeNode root,int l,int h){
        if (root==null)return 0;
        int leftside=0,rightside=0;
        if (root.val>=l&&root.val<=h){
         leftside= getcount(root.left,l,h);
         rightside=getcount(root.right,l,h);
         return 1+leftside+rightside;
        }else if (root.val>h){
            leftside+=getcount(root.left,l,h);
        }else if (root.val<l){
            rightside+=getcount(root.right,l,h);
        }
        return leftside+rightside;


    }
}

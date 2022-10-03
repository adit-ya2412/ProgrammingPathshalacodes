package com.ac;

import static com.ac.searching.searchBST;

public class Inserting {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        TreeNode ans=insertIntoBST(root,5);
        System.out.println(searchBST(ans,5)!=null);
    }
    static TreeNode insertIntoBST(TreeNode root,int val){
        if (root==null){
            root=new TreeNode(val);
            return root;
        }
        TreeNode parent=new TreeNode();
        TreeNode temp=root;
        while (temp!=null){
            parent=temp;
            if (temp.val<val){
                temp=temp.right;
            }else temp=temp.left;
        }
        if (parent.val<val){
            parent.right=new TreeNode(val);
        }else parent.left=new TreeNode(val);
        return root;

    }
}

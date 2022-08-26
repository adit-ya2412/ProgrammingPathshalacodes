package com.ac;

import static com.ac.prunebinarytree.print;

public class Addonerowtotree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(2);
        root.right=new TreeNode(6);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(1);
        root.right.left=new TreeNode(5);
        int val=1;
        int depth=2;
        TreeNode ans=addoneRow(root, val,depth);
        print(ans);
    }
    static TreeNode addoneRow(TreeNode root,int val,int depth){
        if (depth==1){
            TreeNode temp=root;
            TreeNode tt=new TreeNode(val);
            tt.left=root;
            return tt;
        }
        addnode(root,val,1,depth);
        return root;
    }
    static void addnode(TreeNode root,int val,int cuurdepth,int reqdepth){
        if (root==null)return;
        if (cuurdepth+1==reqdepth){
            TreeNode temp=root.left;
            root.left=new TreeNode(val);
            root.left.left=temp;
            temp=root.right;
            root.right=new TreeNode(val);
            root.right.right=temp;
        }else {
            addnode(root.left,val,cuurdepth+1,reqdepth);
            addnode(root.right,val,cuurdepth+1,reqdepth);
        }
    }
}

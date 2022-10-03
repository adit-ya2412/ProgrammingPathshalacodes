package com.ac;

public class deleting2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        TreeNode ans=deletenode(root,3);

    }
    static TreeNode deletenode(TreeNode root,int key){
        if (root!=null){
            if (root.val>key){
                root.left=deletenode(root.left,key);
            }else if (root.val<key){
                root.right=deletenode(root.right,key);
            }else {
                if (root.left==null&&root.right==null)return null;
                if (root.left==null||root.right==null){
                    return (root.left!=null?root.left:root.right);
                }
                    TreeNode temp=root.right;
                    while (temp.left!=null){
                        temp=temp.left;
                    }
                    root.val= temp.val;
                    root.right=deletenode(root.right,temp.val);
            }
        }
        return root;
    }
}

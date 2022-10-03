package com.ac;

public class searching {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(4);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(1);
        root.left.right=new TreeNode(3);
        System.out.println(searchBST(root,11)!=null);
    }
    static public TreeNode searchBST(TreeNode root,int val){
        if (root==null)return root;
        while (root!=null){
            if (root.val<val){
                root=root.right;
            } else if (root.val>val) {
               root=root.left;
            }else return root;
        }
        return root;
    }
}

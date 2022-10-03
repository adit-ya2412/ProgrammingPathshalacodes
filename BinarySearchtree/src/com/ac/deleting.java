package com.ac;

import static com.ac.searching.searchBST;

public class deleting {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        TreeNode ans = deleteNode(root, 3);
        System.out.println(searchBST(ans, 3) == null);
    }

    static TreeNode deleteNode(TreeNode root, int val) {
          TreeNode[]pair=getnode(root,val);
          if (pair[0]==null)return root;
          if (pair[0]==root){
              return deleteroot(root);
          }
          TreeNode n1;
          if (isleaf(pair[0])){
             n1= deleteleaf(pair[0],pair[1]);
          }else if (hassinglechild(pair[0])){
              n1=deletesinglechild(pair[0],pair[1]);
          }else {
              n1=deletedoublechildren(pair[0],pair[1]);
          }
          return root;

    }
    static TreeNode deleteroot(TreeNode root){
        if (isleaf(root))
        {
            root=null;
            return null;
        }
        if(hassinglechild(root)){
            TreeNode ans=(root.left!=null?root.left:root.right);
            root=null;
            return ans;
        }
        TreeNode n1=root.left;
        while (n1.right!=null){
           n1=n1.right;
        }
        TreeNode node=deletedoublechildren(root,null);
        return n1;
    }
    static TreeNode deletedoublechildren(TreeNode node,TreeNode parent){
        TreeNode par=node;
        TreeNode pred=node.left;
        while (pred.right!=null){
            par=pred;
            pred=pred.right;
        }
        TreeNode n1;
        if (isleaf(pred)){
            n1=deleteleaf(pred,par);

        }else n1=deletesinglechild(pred,par);
        if (par!=null&&par.left==node){
            par.left=n1;
        } else if (par!=null) {
            par.right=n1;
        }
        n1.left=node.left;
        n1.right=node.right;
        return node;
    }

    static TreeNode[] getnode(TreeNode root, int val) {
        if (root == null) return new TreeNode[]{null, null};
        TreeNode parent;
        while (root != null) {
            parent = root;
            if (root.val < val) {
                root = root.right;
            } else if (root.val > val) {
                root = root.left;
            } else {
                return new TreeNode[]{root,parent};
            }
        }
        return new TreeNode[]{null, null};
    }

    static boolean isleaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    static TreeNode deleteleaf(TreeNode root, TreeNode parent) {
        if (parent.left == root) parent.left = null;
        else parent.right = null;
        return root;
    }

    static boolean hassinglechild(TreeNode root) {
        return (root.left != null && root.right == null) || (root.right != null && root.left == null);
    }

    static TreeNode deletesinglechild(TreeNode root, TreeNode parent) {
        if (root.left != null) {
            if (parent.left == root) {
                parent.left = root.left;

            } else parent.right = root.left;
            root.left = null;
        } else {
            if (parent.left == root) {
                parent.left = root.right;
            } else parent.right = root.right;
            root.right = null;
        }
        return root;
    }
}


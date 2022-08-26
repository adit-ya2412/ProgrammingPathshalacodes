package com.ac;

public class sumofnodewithevenpairedgrandfather {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(6);
        root.left=new TreeNode(7);
        root.right=new TreeNode(8);
        TreeNode temp=root.left;
        temp.left=new TreeNode(2);
        temp.right=new TreeNode(7);
        temp.left.left=new TreeNode(9);
        temp.right.left=new TreeNode(1);
        temp.right.right=new TreeNode(4);
        temp=root.right;
        temp.left=new TreeNode(1);
        temp.right=new TreeNode(3);
        temp.right.right=new TreeNode(5);
        findsum(root);
        System.out.println(sum);
    }
    static int sum=0;
    static void findsum(TreeNode root){
        if (root==null)return ;
        if (root.left==null&&root.right==null)return;
        if (root.val%2==0) {
            if (root.left!=null&&root.left.left != null) {
                sum += root.left.left.val;
            }
            if (root.left!=null&&root.left.right != null) {
                sum += root.left.right.val;
            }
            if (root.right!=null&&root.right.left != null) {
                sum += root.right.left.val;
            }
            if (root.right!=null&&root.right.right != null) {
                sum += root.right.right.val;
            }
        }
            findsum(root.left);
            findsum(root.right);
        }
    }


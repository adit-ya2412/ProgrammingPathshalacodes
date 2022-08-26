package com.ac;

import java.util.Stack;

public class iterativepreorder {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(3);
        root.right=new TreeNode(7);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(5);
        root.left.right.right=new TreeNode(6);
        root.right.left=new TreeNode(9);
        root.right.right=new TreeNode(10);
        preorder(root);
    }
    static void preorder(TreeNode root){
        Stack<TreeNode>st=new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
                System.out.println(st.peek().val);
                TreeNode temp = st.pop();
                if (temp.right!=null)st.push(temp.right);
                if (temp.left!=null)st.push(temp.left);

        }
    }
}

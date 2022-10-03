package com.ac;

import java.util.Stack;

public class iterativeinorder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);
        inorder(root);
    }

    static void inorder(TreeNode root) {
        Stack<nodewithflag> st = new Stack<>();
        st.push(new nodewithflag(root, 0));
        while (!st.isEmpty()) {
            if (st.peek().flag == 1) System.out.println(st.pop().node.val);
            else {
                TreeNode temp=st.pop().node;
                if (temp.right != null) st.push(new nodewithflag(temp.right,0));
                st.push(new nodewithflag(temp,1));
                if (temp.left != null) st.push(new nodewithflag(temp.left,0));
            }
        }
    }

    static void inorderwithoutflag(TreeNode root){
        Stack<TreeNode>st=new Stack<>();
        while (root.left!=null){
            st.push(root);
            root=root.left;
        }
        while (!st.isEmpty()){
            System.out.println(st.peek().val);
            TreeNode temp=st.pop();
            if (temp.right!=null){
                while (temp.right!=null){
                    st.push(temp);
                    temp=temp.left;
                }
            }
        }
    }
}
class nodewithflag{
    TreeNode node;
    int flag;
    nodewithflag(TreeNode node,int flag){
        this.node=node;
        this.flag=flag;
    }
}

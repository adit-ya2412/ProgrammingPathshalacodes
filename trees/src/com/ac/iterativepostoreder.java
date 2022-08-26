package com.ac;

import java.util.Stack;

public class iterativepostoreder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);
        postorder(root);
    }
    static void postorder(TreeNode root){
        Stack<nodewithflag>st=new Stack<>();
        st.push(new nodewithflag(root,0));
        while (!st.isEmpty()){
            if (st.peek().flag==1){
                System.out.println(st.pop().node.val);
            }else {
                TreeNode temp=st.pop().node;
                st.push(new nodewithflag(temp,1));
                if (temp.right!=null)st.push(new nodewithflag(temp.right,0));
                if (temp.left!=null) st.push(new nodewithflag(temp.left,0));
            }
        }
    }
}

package com.ac;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class zigzagorder {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        TreeNode temp=root.left;
        temp.right=new TreeNode(4);
        temp.left=new TreeNode(1);
        temp.right.left=new TreeNode(3);
        temp.right.right=new TreeNode(7);
        temp.left.right=new TreeNode(2);
        temp.left.right.right=new TreeNode(5);
        temp.left.right.right.left=new TreeNode(9);
        temp=root.right;
        temp.right=new TreeNode(9);
        temp.right.right=new TreeNode(7);
        zigzag(root);

    }
    static void zigzag(TreeNode root){
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        int sz;
        int lev=0;
        TreeNode temp;
        Stack<Integer>st=new Stack<>();
        while (!q.isEmpty()) {
            sz = q.size();
            while (sz != 0) {
                temp = q.poll();
                if (lev % 2 != 0) {
                    st.push(temp.val);
                } else {
                    System.out.print(temp.val);
                }
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
                sz--;
            }
            if (lev % 2 != 0) {
                while (!st.isEmpty()) {
                    System.out.print(st.pop()+" ");
                }
            }
            System.out.println();
      lev++;
        }
    }
}

package com.ac;

import java.util.LinkedList;
import java.util.Queue;

public class levelordertarversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);
        righttoleftlevel(root);
    }
    static void levelorder(TreeNode root){
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            System.out.println(q.peek().val);
            TreeNode temp=q.poll();
            if (temp.left!=null)q.add(temp.left);
            if (temp.right!=null)q.add(temp.right);
        }
    }
    static void levelordermodified(TreeNode root){
        Queue<nodewithflag>q=new LinkedList<>();
        q.add(new nodewithflag(root,0));
        int curr=0;nodewithflag temp;
        while (!q.isEmpty()){
            if (curr==q.peek().flag){
                System.out.print(""+q.peek().node.val);
            }else {
                System.out.println();
                System.out.print(q.peek().node.val);
                curr=q.peek().flag;
            }
            temp=q.poll();
            if (temp.node.left!=null)q.add(new nodewithflag(temp.node.left, temp.flag+1));
            if (temp.node.right!=null)q.add(new nodewithflag(temp.node.right,temp.flag+1));
        }
    }
    static void levelordermod2(TreeNode root){
        Queue<TreeNode>q=new LinkedList<>();
        q.add(root);
        TreeNode temp;
        int sz;
        while (!q.isEmpty()){
            sz=q.size();
            while (sz!=0){
                System.out.print(q.peek().val+" ");
                temp=q.poll();
                if (temp.left!=null)q.add(temp.left);
                if (temp.right!=null)q.add(temp.right);
                sz--;
            }
            System.out.println();
        }
    }
    static void righttoleftlevel(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode temp;
        int sz;

        while (!q.isEmpty()) {
            sz = q.size();
            while (sz != 0) {
                System.out.print("<--" + q.peek().val);
                temp = q.poll();
                if (temp.right != null) q.add(temp.right);
                if (temp.left != null) q.add(temp.left);
                sz--;
            }
            System.out.println();
        }
    }
}

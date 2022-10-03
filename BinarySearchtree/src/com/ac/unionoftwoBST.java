package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class unionoftwoBST {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(1);
        root.right=new TreeNode(4);
        TreeNode root2=new TreeNode(1);
        root2.left=new TreeNode(0);
        root2.right=new TreeNode(3);
        System.out.println(getAllElements(root,root2));
    }

    static List<Integer> getAllElements(TreeNode root1,TreeNode root2){
        Stack<TreeNode>st1=new Stack<>();
        Stack<TreeNode>st2=new Stack<>();
        TreeNode temp =root1;
        while (temp!=null){
            st1.push(temp);
            temp=temp.left;
        }
        temp=root2;
        while (temp!=null){
            st2.push(temp);
            temp=temp.left;
        }
        int val1,val2;
        List<Integer>ans=new ArrayList<>();
        while (!st1.isEmpty()&&!st2.isEmpty()){
            val1=st1.peek().val;
            val2=st2.peek().val;
            if (val1==val2){
                ans.add(val1);
                deleteinvev(st1);
            }else if (val1<val2){
                ans.add(val1);
                deleteinvev(st1);
            }else {
                ans.add(val2);
                deleteinvev(st2);
            }
        }
        while (!st1.isEmpty()){
            ans.add(st1.peek().val);
            deleteinvev(st1);

        }
        while (!st2.isEmpty()){
            ans.add(st2.peek().val);
            deleteinvev(st2);
        }
        return ans;
    }
    static void deleteinvev(Stack<TreeNode>st){
        TreeNode temp=st.pop();
        if (temp.right!=null){
            temp=temp.right;
            while (temp!=null){
                st.push(temp);
                temp=temp.left;
            }
        }
    }
}

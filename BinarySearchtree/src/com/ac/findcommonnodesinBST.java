package com.ac;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Stack;

public class findcommonnodesinBST {
    public static void main(String[] args) {
        Node root1=new Node(5);
        root1.left=new Node(1);
        root1.left.left=new Node(0);
        root1.left.right=new Node(4);
        root1.right=new Node(10);
        root1.right.left=new Node(7);
        root1.right.left.right=new Node(9);
        Node root2=new Node(10);
        root2.left=new Node(7);
        root2.left.right=new Node(9);
        root2.left.left=new Node(4);
        root2.right=new Node(20);
        System.out.println(fincommon(root1,root2));
    }
    static ArrayList<Integer>fincommon(Node root1,Node root2){
        Stack<Node>st1=new Stack<>();
        Stack<Node>st2=new Stack<>();
        Node temp=root1;
        while (temp!=null){
            st1.push(temp);
            temp=temp.left;
        }
        temp=root2;
        while (temp!=null){
            st2.push(temp);
            temp=temp.left;
        }
        ArrayList<Integer>ans=new ArrayList<>();
        int val1,val2;
        while (!st1.isEmpty()&&!st2.isEmpty()){
            val1=st1.peek().data;
            val2=st2.peek().data;
            if (val1==val2){
                ans.add(val1);
                deleteinvev(st1);
                deleteinvev(st2);
            }else if (val1<val2){
                deleteinvev(st1);
            }else {
                deleteinvev(st2);
            }

        }
        return ans;
    }
    static void deleteinvev(Stack<Node>st){
        Node temp=st.pop();
        if (temp.right!=null){
            temp=temp.right;
            while (temp!=null){
                st.push(temp);
                temp=temp.left;
            }
        }
    }
}

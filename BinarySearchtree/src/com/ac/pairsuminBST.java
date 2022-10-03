package com.ac;

import java.util.Stack;

public class pairsuminBST {
    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(5);
        root.left.right=new Node(7);
        root.right=new Node(16);
        root.right.right=new Node(21);
        root.right.right.left=new Node(19);
        System.out.println(isPairPresent(root,26));
    }
    static int isPairPresent(Node root,int sum){
        Stack<Node>st1=new Stack<>();
        Stack<Node>st2=new Stack<>();
        Node temp=root;
        while (temp!=null){
            st1.push(temp);
            temp=temp.left;
        }
        temp=root;
        while (temp!=null){
            st2.push(temp);
            temp=temp.right;
        }
        int s1,s2;
        while (st1.peek()!=st2.peek()){
            s1=st1.peek().data;
            s2=st2.peek().data;
            if (s1+s2==sum)return 1;
            else if (s1+s2>sum){
                deleterev(st2);
            }else {
                deleteinev(st1);
            }
        }
        return 0;

    }
    static void deleterev(Stack<Node>st){
        Node top=st.pop();
        if (top.left!=null){
            top=top.left;
            while (top!=null){
                st.push(top);
                top=top.right;
            }
        }
    }
    static void deleteinev(Stack<Node>st){
        Node top=st.pop();
        if (top.right!=null){
            top=top.right;
            while (top!=null){
                st.push(top);
                top=top.left;
            }
        }
    }
}

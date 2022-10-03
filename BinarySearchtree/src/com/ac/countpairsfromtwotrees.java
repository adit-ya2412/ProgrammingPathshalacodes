package com.ac;

import java.util.Stack;

public class countpairsfromtwotrees {
    public static void main(String[] args) {
        Node root1=new Node(1);
        root1.right=new Node(3);
        root1.right.left=new Node(2);
        Node root2=new Node(3);
        root2.left=new Node(2);
        root2.right=new Node(4);
        root2.left.left=new Node(1);
        System.out.println(countPairs(root1,root2,4));
    }
    static int countPairs(Node root1,Node root2,int x){
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
            temp=temp.right;
        }
        int s1,s2;
        int c=0;
        while (!st1.isEmpty()&&!st2.isEmpty()){
            s1=st1.peek().data;
            s2=st2.peek().data;
            if (s1+s2==x){
                c++;
                deleterev(st2);
                deleteinvev(st1);
            }else if (s1+s2<x){
                deleteinvev(st1);
            }else {
                deleterev(st2);
            }
        }
        return c;
    }
    static void deleterev(Stack<Node>st){
        Node temp=st.pop();
        if (temp.left!=null){
            temp=temp.left;
            while (temp!=null){
                st.push(temp);
                temp=temp.right;
            }
        }
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

package com.ac;

import java.util.ArrayList;

public class leftviewoftree {
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.left.left.right=new Node(8);
        root.right.right=new Node(7);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        ArrayList<Integer>ls=new ArrayList<>();
        System.out.println(rightview(root,ls,0));
    }
    static int max=-1;

    static ArrayList<Integer>leftview(Node root,ArrayList<Integer>ans,int lev){
        if(root==null)return ans;
        if (lev>max){
            max=lev;
            ans.add(root.data);
        }
        leftview(root.left,ans,lev+1);
        leftview(root.right,ans,lev+1);
        return ans;

    }
    static ArrayList<Integer>rightview(Node root,ArrayList<Integer>ans,int lev){
        if (root==null)return ans;
        if (lev>max){
            max=lev;
            ans.add(root.data);
        }
        rightview(root.right,ans,lev+1);
        rightview(root.left,ans,lev+1);
        return ans;
    }
}

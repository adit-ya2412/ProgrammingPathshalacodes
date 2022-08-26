package com.ac;

public class binarytreetodoublylinkedlist {
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.right=new Node(5);
        root.left.right.left=new Node(6);
        root.left.right.right=new Node(7);
        root.right.right=new Node(4);
        root.right.right.left=new Node(8);
       Nodepair ans=convert(root);
        System.out.println(ans.first.data);
    }
    static Nodepair convert(Node root){
        if (root==null)return new Nodepair(null,null);
        Nodepair p1=convert(root.left);
        Nodepair p2=convert(root.right);
        Node head=root;
        Node tail=root;
        root.left=p1.second;
        if (p1.second!=null){
            p1.second.right=root;
            head=p1.first;
        }
        root.right=p2.first;
        if (p2.first!=null){
            p2.first.left=root;
            tail=p2.second;
        }
        return new Nodepair(head,tail);
    }
}
class Nodepair{
    Node first;
    Node second;
    Nodepair(Node first,Node second){
        this.first=first;
        this.second=second;
    }
}

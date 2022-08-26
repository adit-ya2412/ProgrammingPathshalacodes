package com.ac;

public class mirrortree {
    public static void main(String[] args) {
        Node n=new Node(3);


        mirror(n);
    }
    static void mirror(Node n){
        if(n==null)return;
        Node temp=n.left;
        n.left=n.right;
        n.right=temp;
        mirror(n.left);
        mirror(n.right);
    }
}

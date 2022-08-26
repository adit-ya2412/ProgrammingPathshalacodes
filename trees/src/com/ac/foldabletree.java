package com.ac;

public class foldabletree {
    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(7);
        root.right=new Node(15);
        root.left.left=new Node(9);
        root.right.left=new Node(11);
        System.out.println(isfoldable(root));
    }
    static boolean isfoldable(Node root) {
        if (root == null) return false;
        return check(root.left,root.right);
    }
    static boolean check(Node rootleft,Node rootright){
        if (rootleft==null&&rootright==null)return true;
        if (rootleft==null||rootright==null)return false;
        return (check(rootleft.left,rootright.right)&&check(rootleft.right,rootright.left));

    }
}

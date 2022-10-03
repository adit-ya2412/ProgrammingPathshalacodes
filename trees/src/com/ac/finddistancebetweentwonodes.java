package com.ac;

public class finddistancebetweentwonodes {
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(9);
        root.left.left=new Node(3);
        root.left.left.left=new Node(14);
        root.left.right=new Node(4);
        root.left.right.left=new Node(5);
        root.left.right.right=new Node(6);
        root.left.right.right.right=new Node(7);
        root.right=new Node(9);
        root.right.right=new Node(10);
        root.right.right.left=new Node(11);
//        Node p=root.left.left;
//        Node q=root.left.right.right.right;
        System.out.println(finddistance(root,3,7));
    }
    static int l1,l2,l3;
    static int finddistance(Node root,int a,int b){
        Node lca=findlca(root,a,b);
        int lacval=lca.data;
        finddepth(root,a,b,lacval,0);
        return l3+l2-2*l1;

    }
    static void finddepth(Node root,int a,int b,int lca,int depth){
        if (root==null)return;
        if (root.data==lca)l1=depth;
        if (root.data==a)l2=depth;
        if (root.data==b)l3=depth;
        finddepth(root.left,a,b,lca,depth+1);
        finddepth(root.right,a,b,lca,depth+1);
    }
    static Node findlca(Node root,int a,int b){
       if (root==null)return null;
       if (root.data==a||root.data==b)return root;
       Node lef=findlca(root.left,a,b);
       Node ref=findlca(root.right,a,b);
       if (lef==null)return ref;
       if (ref==null)return lef;
       return root;
    }
}

package com.ac;

public class DeleteNodegreaterthanK {
    public static void main(String[] args) {
        Node root=new Node(4);
        root.left=new Node(1);
        root.right=new Node(9);
        Node ans=deletenode(root,2);
        print(ans);
    }
    static void print(Node root){
        if (root==null)return;
        print(root.left);
        System.out.println(root.data);
        print(root.right);
    }
    static Node deletenode(Node root,int k){
        if (root==null)return null;
        root.left=deletenode(root.left,k);
        root.right=deletenode(root.right,k);
        if (root.data>=k){
            Node temp=root.left;
            root.left=null;
            return temp;
        }
        return root;
    }

//    static void traverse(Node root,int k){
//        if (root==null)return;
//        traverse(root.left,k);
//        if (root.data>k){
//            delete(root);
//            root.right=null;
//        }
//        if (root!=null)traverse(root.right,k);
//    }
//    static Node delete(Node root){
//        if (root!=null){
//            if (root.left==null&&root.right==null){
//                return null;
//            }
//            if (root.left==null||root.right==null){
//                return (root.left!=null?root.left:root.right);
//            }
//            Node temp=root.left;
//            while (temp.right!=null){
//                temp=temp.right;
//            }
//            root.data=temp.data;
//            root.left=delete(temp);
//        }
//        return root;
//    }
}

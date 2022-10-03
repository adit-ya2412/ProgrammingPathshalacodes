package com.ac;

public class largestBSTinBT {
    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(5);
        root.right=new Node(7);
        root.left.left=new Node(3);
        root.left.right=new Node(19);
        System.out.println(largestBST(root));
    }
    static int cnt=Integer.MIN_VALUE;
    static int largestBST(Node root){
        traverse(root);
        return cnt;
    }
    static quad traverse(Node root){
        if (root==null)return new quad(true,Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        quad left=traverse(root.left);
        quad right=traverse(root.right);
        int min=Math.min(Math.min(left.min,right.min),root.data);
        int max=Math.max(Math.max(left.max,right.max),root.data);
        int cntt=1+left.cnt+right.cnt;

        if ((left.istree&& right.istree)&&(root.data>left.max&&root.data<right.min)){
            cnt=Math.max(cnt,cntt);
            return new quad(true,min,max,cntt);
        }else {
            return new quad(false,min,max,cntt);
        }
    }
}
class quad{
    boolean istree;
    int min;
    int max;
    int cnt;
    quad(boolean istree,int min,int max,int cnt){
        this.istree=istree;
        this.min=min;
        this.max=max;
        this.cnt=cnt;
    }
}

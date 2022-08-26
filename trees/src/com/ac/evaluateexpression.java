package com.ac;

public class evaluateexpression {
    public static void main(String[] args) {
     SNode root=new SNode("+");
     root.left=new SNode("*");
     root.right=new SNode("-");
     root.right.left=new SNode("100");
     root.right.right=new SNode("20");
     root.left.left=new SNode("5");
     root.left.right=new SNode("4");
        System.out.println(evalTree(root));
    }
    static int evalTree(SNode root) {
        // Your code here.
        if(root==null)return 0;
        int left=evalTree(root.left);
        int right=evalTree(root.right);
        if(root.data.equals("+")){
            return left+right;
        }
        if(root.data.equals("-")){
            return left-right;
        }
        if(root.data.equals("*")){
            return left*right;
        }
        if(root.data.equals("/"))return left/right;
        return Integer.parseInt(root.data);
    }
}
class SNode {
    String data;
    SNode left, right;

    SNode(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


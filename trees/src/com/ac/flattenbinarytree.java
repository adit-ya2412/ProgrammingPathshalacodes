package com.ac;

import static com.ac.prunebinarytree.check;
import static com.ac.prunebinarytree.print;

public class flattenbinarytree {
    public static void main(String[] args) {
//        TreeNode root=new TreeNode(1);
//        root.left=new TreeNode(2);
//        root.left.left=new TreeNode(3);
//        root.left.right=new TreeNode(4);
//        root.right=new TreeNode(5);
//        root.right.right=new TreeNode(6);
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(3);
        convert(root);
        print(root);
    }
    static  TreeNode prev=null;
    static void convert(TreeNode root){
        if(root==null)return;
        convert(root.right);
        convert(root.left);
        root.right=prev;
        root.left=null;
        prev=root;

    }
//    static headtail flat(TreeNode root){
//        if (root==null)return new headtail(null,null);
//        headtail leftpart=flat(root.left);
//        headtail rightpart=flat(root.right);
//        TreeNode hea=root;
//        TreeNode tai=root;
//        root.left=null;
//       // root.right=null;
//        TreeNode tem=hea.right;
//        if (leftpart.head!=null){
//            hea.right=leftpart.head;
//            if (leftpart.tail!=null){
//                leftpart.tail.right=tem;
//            }else {
//                leftpart.head.right=tem;
//                tai=tem;
//            }
//        }
//
//        return new headtail(hea,tai);
//    }

}
class headtail{
    TreeNode head;
    TreeNode tail;
    headtail(TreeNode head,TreeNode tail){
        this.head=head;
        this.tail=tail;
    }
}
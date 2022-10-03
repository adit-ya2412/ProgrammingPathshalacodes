package com.ac;

import java.util.List;

public class linkedlistinbinarytree {
    public static void main(String[] args) {
//        TreeNode root=new TreeNode(1);
//        root.left=new TreeNode(4);
//        root.right=new TreeNode(4);
//        root.left.right=new TreeNode(2);
//        root.left.right.left=new TreeNode(1);
//        root.right.left=new TreeNode(2);
//        root.right.left.left=new TreeNode(6);
//        root.right.left.right=new TreeNode(8);
//        root.right.left.right.left=new TreeNode(1);
//        root.right.left.right.right=new TreeNode(3);
//        ListNode head=new ListNode(4);
//        head.next=new ListNode(2);
//        head.next.next=new ListNode(8);
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(4);
        root.right.left=new TreeNode(3);
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        System.out.println(isSubPath(head,root));

    }
    static boolean isSubPath(ListNode head,TreeNode root){
        if (head==null)return true;
        if (root==null)return false;
        boolean l=false,r=false;
        if (root.val==head.val){
            l=isSubpath(head.next,root.left);
            r=isSubpath(head.next,root.right);
            if (l||r)return true;
        }
        return isSubPath(head,root.left)||isSubPath(head,root.right);
    }
    static boolean isSubpath(ListNode head,TreeNode root){
        if (head==null)return true;
        if (root==null)return false;
        if (root.val== head.val) {
            boolean l=false,r=false;
            l=isSubpath(head.next,root.left);

            r=isSubpath(head.next,root.right);

            return l||r;
        }
        return false;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
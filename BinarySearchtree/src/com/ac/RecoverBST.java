package com.ac;

import java.util.ArrayList;
import java.util.List;

import static com.ac.Serializeanddeserialize.print;

public class RecoverBST {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(3);
        root.left.right=new TreeNode(2);
        //root.right=new TreeNode(4);
        //root.right.left=new TreeNode(2);
        recover2(root);
        print(root);
    }
    static void recover(TreeNode root){
        List<TreeNode>list=new ArrayList<>();
        traverse(root,list);
        int cnt=0;
        TreeNode n1=null,n2=null,n3=null;
        for (int i = 0; i <list.size()-1 ; i++) {
            if (list.get(i).val>list.get(i+1).val) {
                cnt++;
                if (cnt == 1) {
                    n1 = list.get(i);
                    n2 = list.get(i + 1);
                } else if (cnt == 1) {
                    n3 = list.get(i);
                }
            }
        }
        if (cnt==1){
            int temp=n1.val;
            n1.val=n2.val;
            n2.val=temp;
        }else if (cnt==2){
            int temp=n1.val;
            n1.val=n3.val;
            n3.val=temp;
        }

    }
    static void traverse(TreeNode root,List<TreeNode>list){
         if (root==null)return;
         traverse(root.left,list);
         list.add(root);
         traverse(root.right,list);
    }

   static TreeNode n1=null,n2=null,n3=null,prev;
    static int cnt;
    static void recover2(TreeNode root){

        //int cnt=0;
        prev=null;
        traverse(root);
        if (cnt==1){
            int temp=n1.val;
            n1.val= n2.val;
            n2.val=temp;
        }else if (cnt==2){
            int temp=n1.val;
            n1.val=n3.val;
            n3.val=temp;
        }
    }
    static void traverse(TreeNode root){
        if (root==null)return;
        traverse(root.left);
        if (prev!=null&&root.val<prev.val){
            cnt++;
            if (cnt==1){
                n1=prev;
                n2=root;
            }else if (cnt==2){
                n3=root;
            }
            prev=root;
        }else prev=root;
        traverse(root.right);
    }
}

package com.ac;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LCA1 {
    public static void main(String[] args) {
         TreeNode root =new TreeNode(2);
         root.left=new TreeNode(4);
         root.left.left=new TreeNode(5);
         root.left.right=new TreeNode(9);
         root.left.left.right=new TreeNode(7);
         root.right=new TreeNode(10);
         root.right.left=new TreeNode(22);
         root.right.right=new TreeNode(15);
         root.right.right.left=new TreeNode(25);
         TreeNode p=root.right.left;
         TreeNode q=root.left.right;
//         List<TreeNode>temp=new ArrayList<>();
//         traverse(root,p,q,temp);
//        TreeNode ans=findlca(path1,path2);
//        System.out.println(ans.val);
        System.out.println(findlca(root,p,q).val);
    }
    static TreeNode findlca(List<TreeNode>p1,List<TreeNode>p2){
        int i=0;
        while (i<p1.size()&&i<p2.size()){
            if (p1.get(i).val!=p2.get(i).val)break;
            i++;
        }
        return p1.get(i-1);
    }
    static List<TreeNode>path1=new ArrayList<>();
   static List<TreeNode>path2=new ArrayList<>();
    static  void traverse(TreeNode root,TreeNode p,TreeNode q,List<TreeNode>temp){
        if (root==null)return;
        temp.add(root);
        if (root.val== p.val){
            for (TreeNode i:temp) {
                path1.add(i);
            }
        }
        if (root.val==q.val){
            for (TreeNode i:temp) {
                path2.add(i);
            }
        }

        traverse(root.left,p,q,temp);
        traverse(root.right,p,q,temp);
        temp.remove(temp.size()-1);
    }
    static TreeNode findlca(TreeNode root,TreeNode p,TreeNode q){
        if (root==null)return null;
        if(root.val==p.val||root.val==q.val)return root;
        TreeNode lef=findlca(root.left,p,q);
        TreeNode ref=findlca(root.right,p,q);
        if (lef == null)return ref;
        if (ref==null)return lef;
        return root;
    }
}

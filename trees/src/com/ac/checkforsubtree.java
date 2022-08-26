package com.ac;

import java.util.ArrayList;
import java.util.List;

public class checkforsubtree {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(3);
        root.right=new TreeNode(5);
        root.right.left=new TreeNode(7);
        root.right.left.right=new TreeNode(8);
        TreeNode root2=new TreeNode(5);
        root2.left=new TreeNode(7);
        root2.left.right=new TreeNode(8);
        System.out.println(check1(root,root2));
    }
    static boolean check(TreeNode root1,TreeNode root2){
        StringBuilder ans1=new StringBuilder(),ans2=new StringBuilder();
        convertpreorder(root1,ans1);
        convertpreorder(root2,ans2);
        return ans1.toString().contains(ans2.toString());
    }
    static boolean check1(TreeNode root1,TreeNode root2){
        List<Integer>a1=new ArrayList<>(),a2=new ArrayList<>();
        buildpreorder(root1,a1);
        buildpreorder(root2,a2);
        return checkeachwindow(a1,a2);
    }
    static void buildpreorder(TreeNode root,List<Integer>ans){
        if (root==null){
            ans.add(11111);
            return;
        }
        ans.add(root.val);
        buildpreorder(root.left,ans);
        buildpreorder(root.right,ans);
    }
    static void convertpreorder(TreeNode root,StringBuilder ans){
        if (root==null){
            ans.append("111111");
            return;

        }
        ans.append(root.val);
       convertpreorder(root.left,ans);
        convertpreorder(root.right,ans);
    }
    static boolean checkeachwindow(List<Integer>a1,List<Integer>a2){
        int i1=0,j1=0;
        for (int i = 0; i <=a1.size()- a2.size() ; i++) {
            int c=0;
            for (int j = i; j <i+ a2.size() ; j++) {
                 i1=a1.get(j);
                 j1=a2.get(j-i);
                if (i1==j1)c++;
            }
            if (c== a2.size())return true;
        }
        return false;
    }
}

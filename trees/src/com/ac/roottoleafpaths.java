package com.ac;

import java.util.ArrayList;
import java.util.List;

public class roottoleafpaths {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(5);
        System.out.println(binaryTreePaths(root));
    }
    static List<String>binaryTreePaths(TreeNode root){
        List<String>ans=new ArrayList<>();
        String st="";
        if (root.left==null&&root.right==null){
             st=""+root.val;
            ans.add(st);
            return ans;
        }
        paths(root,ans,st);
        return ans;
    }
    static void paths(TreeNode root,List<String>ans,String st){
        if (root==null)return;
        if (st.equals("")){
            st+=root.val;
        }else st+="->"+root.val;
        if (root.left==null&&root.right==null){
            ans.add(st);
            return;
        }

        paths(root.left,ans,st);
        paths(root.right,ans,st);
        st=st.substring(0,st.length()-1);
    }

}

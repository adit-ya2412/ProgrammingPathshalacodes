package com.ac;

import java.util.ArrayList;
import java.util.List;

public class fliptomatchpreorder {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        int[]voyage={1,3,2};
        List<Integer>ans=new ArrayList<>();
        flipsearch(root,voyage);
        ans.add(flips);
        System.out.println(ans);

    }
    static int idx=0;
    static int flips=0;
    static void flipsearch(TreeNode root,int[]voyage){
        if (root==null)return;
        if (root.left!=null&&root.left.val!=voyage[idx+1]){
            if (root.right==null||root.right.val!=voyage[idx+1]){
                flips=-1;
                return;
            }else {
                int temp=root.left.val;
                root.left.val=root.right.val;
                root.right.val=temp;
                flips++;
                idx++;
            }
        }else {
            flips=-1;
            return;
        }
        flipsearch(root.left,voyage);
        flipsearch(root.right,voyage);
    }
}

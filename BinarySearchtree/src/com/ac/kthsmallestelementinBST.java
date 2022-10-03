package com.ac;

public class kthsmallestelementinBST {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(6);
        root.right=new TreeNode(20);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(9);
        root.left.right.left=new TreeNode(7);
        root.right.left=new TreeNode(15);
        ksmallest(root,3);
        System.out.println(ans);
    }
    static int ans;
    static int cnt=1;
    static void ksmallest(TreeNode root,int k){
        if (root==null)return;

            ksmallest(root.left,k);
            if (cnt++==k){
                ans= root.val;
                return;
            }

            ksmallest(root.right,k);

    }
}

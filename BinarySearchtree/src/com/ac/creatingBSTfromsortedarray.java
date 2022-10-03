package com.ac;

public class creatingBSTfromsortedarray {
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6,7,8};
        TreeNode ans=create(arr,0,arr.length-1);
        traverse(ans);
    }
    static void traverse(TreeNode root){
        if (root==null)return;
        traverse(root.left);
        System.out.println(root.val);
        traverse(root.right);
    }
    static TreeNode create(int[]arr,int st,int end){
        if (st>end)return null;
        int mid=(st+end)/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=create(arr,st,mid-1);
        root.right=create(arr,mid+1,end);
        return root;
    }
}

package com.ac;

public class Serializeanddeserialize {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(47);
        root.left=new TreeNode(33);
        root.right=new TreeNode(85);
        root.right.left=new TreeNode(76);
        root.right.right=new TreeNode(99);
        String serial=serialize(root);
        System.out.println(serial);
        TreeNode ans=deserialize(serial);
        print(ans);
    }
    static void print(TreeNode ans){
        if (ans==null)return;
        print(ans.left);
        System.out.println(ans.val);
        print(ans.right);
    }
    static int idx=0;
    static TreeNode deserialize(String data){
        if (data.length()==0)return null;
        String[]datap=data.split(",");
        return create(datap,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    static TreeNode create(String[]data,int lb,int ub){
        if (idx<data.length){
            int num=Integer.parseInt(data[idx]);
            if (num<ub&&num>lb){
                TreeNode root=new TreeNode(num);
                idx++;
                root.left=create(data,lb,root.val);
                root.right=create(data,root.val,ub);
                return root;
            }
        }
        return null;
    }
    static String serialize(TreeNode root){
        StringBuilder br=new StringBuilder();
        traverse(root,br);
        return br.toString();
    }
    static void traverse(TreeNode root,StringBuilder br){
        if (root==null)return;
        br.append(root.val+",");
        traverse(root.left,br);
        traverse(root.right,br);
    }
}

package com.ac;

public class Maximumsumpath {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(-10);
        root.left=new TreeNode(9);
        root.right=new TreeNode(20);
        root.right.left=new TreeNode(15);
        root.right.right=new TreeNode(7);
        System.out.println(maxsum(root));
    }
    static int maxsum(TreeNode root){
        if (root.left==null&&root.right==null)return root.val;
        msumandmuni ans=calc(root);
        return ans.maxsum_path;
    }
    static msumandmuni calc(TreeNode root){
        if (root==null)return new msumandmuni(Integer.MIN_VALUE,0);
        msumandmuni p1=calc(root.left);
        msumandmuni p2=calc(root.right);
        int maxsumpath=Math.max(root.val+Math.max(0, p1.maxsum_unipath)+Math.max(0, p2.maxsum_unipath), Math.max(p1.maxsum_path, p2.maxsum_path));
        int maxunipath=root.val+Math.max(Math.max(p1.maxsum_unipath,p2.maxsum_unipath),0);
        return new msumandmuni(maxsumpath,maxunipath);
    }
}
class msumandmuni{
    int maxsum_path;
    int maxsum_unipath;
    msumandmuni(int maxsum_path,int maxsum_unipath){
        this.maxsum_path=maxsum_path;
        this.maxsum_unipath=maxsum_unipath;
    }
}

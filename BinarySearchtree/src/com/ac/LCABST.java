package com.ac;

public class LCABST {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(6);
        root.left=new TreeNode(2);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(0);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(3);
        root.left.right.right=new TreeNode(5);
        root.right.left=new TreeNode(7);
        root.right.right=new TreeNode(9);
        TreeNode p=root.left;
        TreeNode q=root.right;
        //System.out.println(lowestCommonAncestor(root,p,q).val);
        System.out.println(LCA(root,p,q).val);
    }
    static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        TreeNode temp=root;
        while (temp!=null){
            if (temp.val<p.val&&temp.val< q.val){
                temp=temp.right;
            }else if (temp.val>p.val&&temp.val>q.val){
                temp=temp.left;
            }else if (temp.val==p.val||temp.val==q.val)return temp;
            else return temp;
        }
        return null;
    }
    static TreeNode LCA(TreeNode root,TreeNode p,TreeNode q){
        if (root==null)return null;
        if (root.val==p.val||root.val==q.val)return root;
        int max=Math.max(p.val,q.val);
        int min=Math.min(p.val,q.val);
        if (root.val>min&&root.val<max)return root;
        if (root.val<min&&root.val<max){
            return LCA(root.right,p,q);
        }else return LCA(root.left,p,q);
    }


}

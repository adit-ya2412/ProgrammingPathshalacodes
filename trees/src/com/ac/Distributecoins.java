package com.ac;

public class Distributecoins {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(0);
        root.left=new TreeNode(3);
        //root.left.left=new TreeNode(3);
        root.right=new TreeNode(0);
        System.out.println(distributeCoins(root));
    }
    static int steps=0;
    static int distributeCoins(TreeNode root){
        dfs(root);
        return steps;
    }
    static int dfs(TreeNode root){
        if (root==null)return 0;
        int leftcoin=dfs(root.left);
        int rightcoint=dfs(root.right);
        int coin=0;
        if (root.val==0){
            coin=leftcoin+rightcoint-1;
        }else {
            coin=leftcoin+rightcoint+(root.val-1);
        }
        steps+=Math.abs(coin);
        return coin;
    }
}

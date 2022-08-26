package com.ac;

import java.util.Scanner;

import static com.ac.prunebinarytree.print;

public class constructusingpreordertraversal {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
      int[]preorder=new int[n];
        for (int i = 0; i <n ; i++) {
            preorder[i]=sc.nextInt();
        }
        TreeNode ans=build(preorder);
        print(ans);
    }
    static int idx=0;
    static TreeNode build(int[]preorder){
        if (preorder[idx]==-1){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(preorder[idx]);
        idx++;
        root.left=build(preorder);
        root.right=build(preorder);
        return root;
    }
}

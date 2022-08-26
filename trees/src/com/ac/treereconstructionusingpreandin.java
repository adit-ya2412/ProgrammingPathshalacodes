package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import static com.ac.prunebinarytree.print;

public class treereconstructionusingpreandin {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[]preorder=new int[n];
        String[]inpu=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            preorder[i]=Integer.parseInt(inpu[i]);
        }
        int[]inorder=new int[n];
        inpu=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            inorder[i]=Integer.parseInt(inpu[i]);
        }
        HashMap<Integer,Integer>inordermap=new HashMap<>();
        for (int i = 0; i <n ; i++) {
            inordermap.put(inorder[i],i);
        }
        int i1=0;
        int j1=n-1;
        int i2=0;
        int j2=n-1;
        TreeNode ans=build(i1,j1,preorder,i2,j2,inordermap);

        print(ans);
    }
    static TreeNode build(int i1,int j1,int[]preorder,int i2,int j2,HashMap<Integer,Integer>inorder){
        if (i1>j1)return null;
        TreeNode root=new TreeNode(preorder[i1]);
        int i;
        i=inorder.get(preorder[i1]);
        TreeNode left=build(i1+1,i1+i-i2,preorder,i2,i-1,inorder);
        TreeNode right=build(i1+i-i2+1,j1,preorder,i+1,j2,inorder);
        root.left=left;
        root.right=right;
        return root;
    }
}

package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import static com.ac.prunebinarytree.print;

public class treeconstrucrtionusingpostandinorder {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        String[]inpu=(br.readLine().trim()).split("\\s+");
        int[]inorder=new int[n];
        int[]postorder=new int[n];
        for (int i = 0; i <n ; i++) {
            inorder[i]=Integer.parseInt(inpu[i]);
        }
        inpu=(br.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            postorder[i]=Integer.parseInt(inpu[i]);
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        int count=0;
        for (int i:inorder){
            map.put(i,count);
            count++;
        }
        TreeNode root=build(0,inorder.length-1,0,postorder.length-1,postorder,map);
        print(root);
    }
    static TreeNode build(int ist,int iend,int ps,int pe,int[]postorder,HashMap<Integer,Integer>inorder){
        if (ps>pe||ist>iend)return null;
        TreeNode root=new TreeNode(postorder[pe]);
        int i=inorder.get(postorder[pe]);
        int dif=i-ist;
        root.left=build(ist,i-1,ps,ps+dif-1,postorder,inorder);
        root.right=build(i+1,iend,ps+dif,pe-1,postorder,inorder);
        return root;
    }
}

package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static com.ac.prunebinarytree.print;

public class recovertreefrompreorder {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String st=(br.readLine().trim());
        TreeNode ans=recoverfrompreorder(st);
        print(ans);
    }
    static int idx=0;
    static TreeNode recoverfrompreorder(String traversal) {
        TreeNode ans=build(traversal,0);
        return ans;
    }
    static TreeNode build(String traversal,int currlev){
         if (idx>=traversal.length())return null;
         int cnt=0;
         int i=idx;
         while (traversal.charAt(i)=='-'){
             cnt++;
             i++;
         }
         if (cnt==currlev){
             idx=i;
             String num="";
             while (i<traversal.length()&&traversal.charAt(i)!='-'){
                 num+=traversal.charAt(i);
                 i++;
             }
             TreeNode root=new TreeNode(Integer.parseInt(num));
             idx=i;
             root.left=build(traversal,currlev+1);
             root.right=build(traversal,currlev+1);
             return root;
         }else return null;
    }

}

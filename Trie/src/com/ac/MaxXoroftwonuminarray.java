package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MaxXoroftwonuminarray {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        int[]arr=new int[n];
        String[]inputs=(br.readLine().trim()).split(",");
        for (int i = 0; i < n ; i++) {
            arr[i]=Integer.parseInt(inputs[i]);
        }
        System.out.println(findMaximumXor(arr));
    }
    static int findMaximumXor(int[]nums){
        Node root=new Node();
        String s;
        for (int i = 0; i <nums.length ; i++) {
            s=makebinary(nums[i]);
            insert(s,0,root,nums[i]);
        }
        int maxxor=Integer.MIN_VALUE;
        int ans;
        for (int i = 0; i <nums.length ; i++) {
            s=makebinary(nums[i]);
            ans=findmax(s,root);
            maxxor=Math.max(ans^nums[i],maxxor);
        }
        return maxxor;

    }
    static int findmax(String num,Node root){
        Node curr=root;
        for (int i = 0; i < num.length() ; i++) {
            if (curr.left==null||curr.right==null){
                curr=(curr.left==null?curr.right:curr.left);
            }else {
                if (num.charAt(i)=='0')curr=curr.right;
                else curr=curr.left;
            }
        }
        return curr.num;
    }
    static void insert(String word,int pos,Node root,int num){
        if (pos==word.length()){
            root.num=num;
            return;
        }
        if (word.charAt(pos)=='0'){
            if (root.left!=null){
                insert(word,pos+1,root.left,num);
            }else {
                root.left=new Node();
                insert(word,pos+1,root.left,num);
            }
        }else {
            if (root.right!=null){
                insert(word,pos+1,root.right,num);
            }else {
                root.right=new Node();
                insert(word,pos+1,root.right,num);
            }
        }
    }
    static String makebinary(int number){
        int base=31;
        int x;
        StringBuilder br=new StringBuilder();
        while (base>=0){
            x=number%2;
            br.append(x);
            number=number/2;
            base--;
        }
        return br.reverse().toString();
    }
}

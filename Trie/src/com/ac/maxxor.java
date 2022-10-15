package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class maxxor {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]input=(br.readLine().trim()).split(",");
        int n=input.length;
        int[]arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(input[i]);
        }
        System.out.println(maxSubarrayXor(n,arr));
    }
    static int  maxSubarrayXor(int N,int[]arr){
        Node root=new Node();
        insert(arr[0],root);
        int overall=-1;
        int maxxor=Integer.MIN_VALUE;
        for (int i = 1; i <N ; i++) {
            int xor=findmax(arr[i],root);
            int xornum=xor^arr[i];
            if (overall==-1)overall=xornum;
            else {
                overall=Math.max(overall^arr[i],xornum);
            }
            insert(arr[i],root);
        }

        return overall;

    }
    static int findmax(int num,Node root){
        for (int i = 31; i >=0 ; i--) {
            int bin=(num&(1<<i));
            if (root.left==null||root.right==null){
                root=(root.left==null?root.right:root.left);
            }else if (bin!=0){
                root=root.left;
            }else root=root.right;
        }
        return root.num;
    }
    static void insert(int numm,Node root){
        for (int i = 31; i >=0 ; i--) {
            int bin=(numm&(1<<i));
            if (bin==0){
                if (root.left!=null){
                    root=root.left;
                }else {
                    root.left=new Node();
                    root=root.left;
                }
            }else {
                if (root.right!=null){
                    root=root.right;
                }else {
                    root.right=new Node();
                    root=root.right;
                }
            }
            root.num=numm;
        }
    }
}

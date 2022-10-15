package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

import static com.ac.storingnumbersintrie.printallnumbers;

public class minimumxor {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]input=(br.readLine().trim()).split(",");
        int n=input.length;
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(input[i]);
        }
        System.out.println(minxorpair(n,arr));
    }
    static int minxorpair(int N,int[]arr){
        Node root=new Node();
        insert(arr[0],root);
        int minxor=Integer.MAX_VALUE;
        for (int i = 1; i <N ; i++) {
            int xor=findmin(arr[i],root);
            minxor=Math.min(xor^arr[i],minxor);
            insert(arr[i],root);
        }
        //printallnumbers(root);

        return minxor;
    }
    static int findmin(int num,Node root){
        for (int i = 31; i >=0 ; i--) {
            int bin=(num&(1<<i));
            if (root.left==null||root.right==null){
                root=(root.left==null?root.right:root.left);
            }else {
                if (bin!=0){
                    root=root.right;
                }else root=root.left;
            }

        }
        return root.num;
    }
    static void insert(int num,Node root){
        for (int i = 31; i >=0; i--) {
            int bin=(num&(1<<i));
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
        }
        root.num=num;
    }
}

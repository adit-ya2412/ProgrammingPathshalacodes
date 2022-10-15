package com.ac;

import java.util.Scanner;

public class storingnumbersintrie {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        Node root=new Node();
        for (int i = 0; i <n ; i++) {
            String s=convert(arr[i],31);
            insert(s,0,root,arr[i]);
        }
        printallnumbers(root);
    }
    static void printallnumbers(Node root){
        if (root.num!=-1){
            System.out.println(root.num);
            return;
        }
        if (root.left!=null)printallnumbers(root.left);
        if (root.right!=null)printallnumbers(root.right);

    }
    static void insert(String word,int pos,Node root,int num){
        if (pos==word.length()){
            root.num=num;
            return;
        }
        if (word.charAt(pos)=='0'){
            if (root.left==null){
                root.left=new Node();
                insert(word,pos+1,root.left,num);
            }else insert(word,pos+1,root.left,num);
        }else {
            if (root.right==null){
                root.right=new Node();
                insert(word,pos+1,root.right,num);
            }else insert(word,pos+1,root.right,num);
        }
    }
    static String convert(int num,int base){
        String temp="";
        int x;
        while (base>=0){
            x=num%2;
            temp+=x;
            num=num/2;
            base--;
        }
        StringBuilder br=new StringBuilder(temp);
        return br.reverse().toString();
    }
}
class  Node{
    Node left;
    Node right;
    int num;
    Node(){
        this.num=-1;
        this.left=null;
        this.right=null;
    }
}

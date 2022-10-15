package com.ac;

import java.util.Scanner;

public class findprefix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TrieNode root=createnode();
        int n=sc.nextInt();
        for (int i = 0; i <n ; i++) {
            String iput=sc.next();
            insert(iput,0,root);
        }
        System.out.println(countprefix("abr",0,root));
        System.out.println(countprefix("geeks",0,root));
        System.out.println(countprefix("geeksforgeeks",0,root));
    }
    static TrieNode createnode(){
        TrieNode root=new TrieNode();
        root.end=false;
        root.subtreestrings=0;
        for (int i=0;i<26;i++){
            root.children[i]=null;
        }
        return root;
    }
    static boolean search(String word,int pos,TrieNode root){
        if (root==null)return false;
        if (pos==word.length()){
            if (root.end){
                return true;
            }
            return false;
        }
        return search(word,pos+1,root.children[word.charAt(pos)-'a']);
    }
    static void insert(String input,int pos,TrieNode root){
        if (pos==input.length()){
            root.subtreestrings++;
            root.end=true;
            return;
        }
        root.subtreestrings++;
        if ((root.children[input.charAt(pos)-'a']==null)){
               root.children[input.charAt(pos)-'a']=createnode();
        }
            insert(input,pos+1,root.children[input.charAt(pos)-'a']);

    }
    static int countprefix(String prefix,int pos,TrieNode root){
        if (root==null)return 0;
        if (pos==prefix.length())return root.subtreestrings;
        return countprefix(prefix,pos+1,root.children[prefix.charAt(pos)-'a']);
    }
    static boolean found=false;
    static void deletion(String word,int pos,TrieNode root){

        if (root==null)return;
        if (pos==word.length()){
            if (root.end){
                found=true;
                root.subtreestrings--;
            }
            return;
        }
        deletion(word,pos+1,root.children[word.charAt(pos)-'a']);
        if (found)root.subtreestrings--;
        if (root.children[word.charAt(pos)-'a'].subtreestrings==0){
            TrieNode node=root.children[word.charAt(pos)-'a'];
            root.children[word.charAt(pos)-'a']=null;
        }
    }
}

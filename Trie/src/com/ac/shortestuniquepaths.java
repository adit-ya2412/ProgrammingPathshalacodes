package com.ac;

import java.util.Scanner;

public class shortestuniquepaths {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      String[]arr=new String[n];

        for (int i= 0; i<n ; i++) {
          arr[i]=sc.next();
        }

        String[]ans=findprefixes(arr,n);

        for (String i:ans) {
            System.out.println(i);
        }
    }
    static String[]findprefixes(String[]arr,int N){
        TrieNode root=new TrieNode();
        for(int i=0;i<arr.length;i++){
            insert(arr[i],0,root);
        }
        String[]ans=new String[arr.length];
        for(int i=0;i<N;i++){
            ans[i]=findshortest(arr[i],root);
        }
        return ans;
    }
    static String findshortest(String prefix,TrieNode root){
        String ans="";
        TrieNode curr=root;
        int i;
        for ( i = 0; i <prefix.length() ; i++) {
            if (curr.children[prefix.charAt(i)-'a']!=null){
                if (curr.subtreestrings==1)break;
                curr=curr.children[prefix.charAt(i)-'a'];
            }else break;
        }
        if (curr.subtreestrings==1)return prefix.substring(0,i);
        return ans;
    }
    static void insert(String word,int pos,TrieNode root){
        if(pos==word.length()){
            root.subtreestrings++;
            root.end=true;
            return;
        }
        root.subtreestrings++;
        if(root.children[word.charAt(pos)-'a']==null){
            root.children[word.charAt(pos)-'a']=new TrieNode();
        }
        insert(word,pos+1,root.children[word.charAt(pos)-'a']);
    }
}

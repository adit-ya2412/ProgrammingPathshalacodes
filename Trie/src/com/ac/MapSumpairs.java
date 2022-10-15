package com.ac;

import java.io.IOException;

public class MapSumpairs {
    public static void main(String[] args)throws IOException {
      MapSum obj=new MapSum();
      obj.insert("apple",3);
        System.out.println(obj.sum("apple"));
        obj.insert("app",2);
        System.out.println(obj.sum("ap"));
        obj.insert("apple",5);
        obj.insert("apple",1);
        System.out.println(obj.sum("apple"));
    }
}
class MapSum{
    TrieNode1 root;
    public MapSum(){
        root=new TrieNode1();
    }
    public void insert(String key,int val){
        TrieNode1 curr=root;
        for (int i=0;i<key.length();i++){
            if (curr.children[key.charAt(i)-'a']==null){
                curr.children[key.charAt(i)-'a']=new TrieNode1();
            }
            curr=curr.children[key.charAt(i)-'a'];
        }
        curr.val=val;
        curr.end=true;
    }
    public int sum(String prefix){
      TrieNode1 curr=root;
      int sum=0;
        for (int i = 0; i <prefix.length() ; i++) {
            ///if (curr.end==true)curr.val+=sum;
            if (curr.children[prefix.charAt(i)-'a']!=null){
                curr=curr.children[prefix.charAt(i)-'a'];
            }else return 0;
        }
        if (curr.end)sum+=curr.val;
        for (int i = 0; i <26 ; i++) {

            if (curr.children[i]!=null){
                sum+=findwords(curr.children[i],0);
            }
        }
        return sum;

    }
    public int findwords(TrieNode1 root,int sum){
        if (root.end=true){
            sum+=root.val;
        }
        for (int i=0;i<26;i++){
            if (root.children[i]!=null){
                sum+=findwords(root.children[i],0 );
            }
        }
        return sum;
    }
}
class TrieNode1{
    boolean end;
    int val;
    TrieNode1[] children=new TrieNode1[26];
    TrieNode1(){
        this.end=false;
        this.val=0;
        for (int i = 0; i <26; i++) {
            this.children[i]=null;
        }
    }
}

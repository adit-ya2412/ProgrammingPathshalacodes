package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class phonedirectory {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        String[]contact=(br.readLine().trim()).split("\\s+");
//        for (int i = 0; i <n ; i++) {
//            contact[i]=br.readLine().trim();
//        }
        String query=br.readLine().trim();
        System.out.println(displayContacts(n,contact,query));
    }
    static ArrayList<ArrayList<String>> displayContacts(int n,String[]contact,String s){
        TrieNode root=new TrieNode();
        for (int i = 0; i <n ; i++) {
            insert(contact[i],0,root);
        }
        ArrayList<ArrayList<String>>ans=new ArrayList<>();
        for (int i = 1; i <=s.length() ; i++) {
            ans.add(findstrings(i,root,s,0));
        }
        return ans;
    }
    static ArrayList<String>findstrings(int end,TrieNode root,String word,int pos ){
        if (pos==end){
            String word1=word.substring(0,pos);
            ArrayList<String>temp=new ArrayList<>();
            for (int i = 0; i <26 ; i++) {
                if (root.children[i]!=null)findwords(root.children[i],i,word1,temp);
            }
            return temp;
        }
        if (root.children[word.charAt(pos)-'a']==null){
            ArrayList<String>temp=new ArrayList<>();
            temp.add("0");
            return temp;
        }
        return findstrings(end,root.children[word.charAt(pos)-'a'],word,pos+1);
    }
    static void findwords(TrieNode root,int pos,String word,ArrayList<String>temp) {
        if (root.end == true) {
            word += (char) (pos + 'a');
            temp.add(word);
            // return;
        } else {
            word += (char) (pos + 'a');
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    findwords(root.children[i], i, word, temp);
                }
            }

        }
    }
    static void insert(String word,int pos,TrieNode root){
        if (pos==word.length()){
            root.subtreestrings++;
            root.end=true;
            return;
        }
        root.subtreestrings++;
        if (root.children[word.charAt(pos)-'a']==null){
            root.children[word.charAt(pos)-'a']=new TrieNode();
        }
        insert(word,pos+1,root.children[word.charAt(pos)-'a']);
    }
}

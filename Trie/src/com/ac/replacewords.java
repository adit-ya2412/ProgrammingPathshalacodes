package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class replacewords {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        List<String >dictionary=new ArrayList<>();
        int n=Integer.parseInt(br.readLine().trim());
        String sentence=br.readLine().trim();
        for (int i = 0; i < n; i++) {
            dictionary.add(br.readLine().trim());
        }
        System.out.println(replacedwords(dictionary,sentence));
    }
    static String replacedwords(List<String>dictionary,String sentence){
        TrieNode root=new TrieNode();
        for (int i = 0; i <dictionary.size() ; i++) {
            insert(dictionary.get(i),0,root);
        }
        String[]words=sentence.split("\\s+");
        StringBuilder br=new StringBuilder();
        for (int i = 0; i <words.length ; i++) {
            br.append(replace(words[i],root)+" ");
        }
        return br.toString().trim();
    }
    static String replace(String word,TrieNode root){
        TrieNode curr=root;
        int i;
        for ( i = 0; i <word.length() ; i++) {
            if (curr.children[word.charAt(i)-'a']!=null){
                if (curr.end)return word.substring(0,i);
                curr=curr.children[word.charAt(i)-'a'];
            }else break;
        }
        if (curr.end==true)return word.substring(0,i);
        else return word;
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

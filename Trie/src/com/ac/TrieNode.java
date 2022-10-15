package com.ac;

public class TrieNode {
    int subtreestrings;
    boolean end;
    TrieNode[]children=new TrieNode[26];
    TrieNode(){
        this.subtreestrings=0;
        this.end=false;
        for (int i = 0; i <26 ; i++) {
            this.children[i]=null;
        }
    }
}


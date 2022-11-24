package com.ac;

import java.util.*;

public class wordladder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<String>wordlist=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            wordlist.add(sc.next());
        }
        String startword=sc.next();
        String endword=sc.next();
        System.out.println(ladderlength(startword,endword,wordlist));
    }
    static int ladderlength(String beginWord,String endWord,List<String>wordList){
        Set<String>words=new HashSet<>();
        for (String s:wordList){
            words.add(s);
        }
        if (!words.contains(endWord))return 0;
        HashMap<String,Boolean>visited=new HashMap<>();
        Queue<pairstring>queue=new LinkedList<>();
        visited.put(beginWord,true);
        queue.add(new pairstring(beginWord,1));
        StringBuilder br;
        while (!queue.isEmpty()){
            pairstring node=queue.poll();
             String temp=node.s;
             if (temp.equals(endWord))return node.dist;
            br=new StringBuilder(temp);
            for (int i = 0; i <temp.length() ; i++) {
                char ch=temp.charAt(i);
                for (int j = 0; j <26 ; j++) {
                    char rep= (char) (j+'a');
                    br.setCharAt(i,rep);
                    if (words.contains(br.toString())&&(!visited.getOrDefault(br.toString(),false))){
                        visited.put(br.toString(),true);
                        queue.add(new pairstring(br.toString(),node.dist+1));
                    }
                }
                br.setCharAt(i,ch);
            }
        }
        return 0;
    }
}
class pairstring{
    String s;
    int dist;
    pairstring(String s,int dist){
        this.s=s;
        this.dist=dist;
    }
}

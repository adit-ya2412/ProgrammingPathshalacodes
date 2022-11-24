package com.ac;

import java.util.*;

public class WordladderII {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<String> wordlist=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            wordlist.add(sc.next());
        }
        String startword=sc.next();
        String endword=sc.next();
        System.out.println(findladders(startword,endword,wordlist));
    }
    static List<List<String>>findladders(String startword,String endword,List<String>wordlist){
        List<List<String>>ans=new ArrayList<>();
        HashMap<String,List<String>>adj=new HashMap<>();
        Set<String>words=new HashSet<>(wordlist);
        if (!words.contains(endword))return ans;
        Queue<String>queue=new LinkedList<>();
        HashMap<String,Integer>visited=new HashMap<>();
        queue.add(startword);
        visited.put(startword,0);
        StringBuilder br;
        String curr;
        adj.put(startword,new ArrayList<>());
        while (!queue.isEmpty()){
            br=new StringBuilder(queue.poll());
            curr=br.toString();
            if (!adj.containsKey(curr)){
                adj.put(curr,new ArrayList<>());
            }
            for (int i = 0; i <br.length() ; i++) {
                char temp=br.charAt(i);
                for (int j = 0; j <26 ; j++) {
                    char ch=(char)(j+'a');
                    br.setCharAt(i,ch);
                    if (words.contains(br.toString())){
                        if (visited.containsKey(br.toString())){
                            if (visited.get(br.toString())==visited.get(curr)+1){
                                adj.get(curr).add(br.toString());
                            }
                        }else {
                         visited.put(br.toString(),visited.get(curr)+1);
                         queue.add(br.toString());
                         adj.get(curr).add(br.toString());
                        }
                    }
                }
                br.setCharAt(i,temp);
            }

        }
        if (adj.get(startword).size()==0)return ans;
        dfs(adj,new ArrayList<>(),ans,startword,endword,visited.get(endword),0);


     return ans;
    }
    static void dfs(HashMap<String,List<String>>adj,List<String>temp,List<List<String>>ans,String startword,String endword,int dist,int currdist){
        if (currdist>dist)return;
        if (startword.equals(endword)){
            temp.add(endword);
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        for (int i = 0; i <adj.get(startword).size() ; i++) {
            temp.add(startword);
            dfs(adj,temp,ans,adj.get(startword).get(i),endword,dist,currdist+1);
            temp.remove(temp.size()-1);
        }
    }
}
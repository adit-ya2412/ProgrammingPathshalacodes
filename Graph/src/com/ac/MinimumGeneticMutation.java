package com.ac;

import java.util.*;

public class MinimumGeneticMutation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String start=sc.next();
        String end=sc.next();
        int n=sc.nextInt();
        String[]bank=new String[n];
        for (int i = 0; i <n ; i++) {
            bank[i]=sc.next();
        }
        System.out.println(minMutation(start,end,bank));
    }
    static int minMutation(String start,String end,String[]bank){
        HashMap<String,Boolean>maps=new HashMap<>();
        for (String i:bank){
            maps.put(i,true);
        }
        List<Character>genevalue=new ArrayList<>();
        genevalue.add('A');
        genevalue.add('C');
        genevalue.add('G');
        genevalue.add('T');
        Set<String>visited=new HashSet<>();
        visited.add(start);
        Queue<stringdistances>queue=new LinkedList<>();
        queue.add(new stringdistances(start,0));
        while (!queue.isEmpty()){
            stringdistances adj=queue.poll();
            if (adj.gen.equals(end))return adj.dist;
            StringBuilder br=new StringBuilder(adj.gen);
            for (int i = 0; i <adj.gen.length() ; i++) {
                char ch=adj.gen.charAt(i);
                for (int j = 0; j <genevalue.size() ; j++) {
                    br.setCharAt(i,genevalue.get(j));
                    if (maps.containsKey(br.toString())){
                        if (!visited.contains(br.toString())){
                            visited.add(br.toString());
                            queue.add(new stringdistances(br.toString(),adj.dist+1));
                        }
                    }
                }
                br.setCharAt(i,ch);
            }
        }
        return -1;
    }
}
class stringdistances{
    String gen;
    int dist;
    stringdistances(String gen,int dist){
        this.gen=gen;
        this.dist=dist;
    }
}

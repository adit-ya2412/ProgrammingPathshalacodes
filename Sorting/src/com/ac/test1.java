package com.ac;

import java.util.*;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] freq = new int[m+1];
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i<n ; i++){
            String surName = sc.next();
            int region = sc.nextInt();
            freq[region]++;
            int score = sc.nextInt();
            list.add(new Pair(surName,region,score));
    }
        Collections.sort(list,new comp());

        for(int i =n-1,j=1; i>=0 && j<=m; ){
            if(freq[j]>2) {
                int y = list.get(i - 1).score;
                int z = list.get(i - 2).score;
                if(y==z){
                    System.out.println("?");

                } else {
                    System.out.println(list.get(i).surName+" "+list.get(i-1).surName);
                }
                i=i-freq[j];
                j++;
            }
            else{
                System.out.println(list.get(i).surName+" "+list.get(i-1).surName);
                i=i-2;
                j++;
            }
        }
    }
}
class Pair {
    String surName;
    int region;
    int score;
    Pair(String surName, int region, int score){
        this.surName = surName;
        this.region = region;
        this.score = score;
    }
}
class comp implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        if(o1.region!= o2.region){
            return o2.region-o1.region;
        } else {
            return o1.score - o2.score;
        }
    }
}

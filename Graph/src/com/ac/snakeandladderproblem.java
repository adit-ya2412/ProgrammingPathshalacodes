package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class snakeandladderproblem {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine().trim());
        String[]inputs=(br.readLine().trim()).split("\\s+");
        int[]arr=new int[2*n];
        for (int i = 0; i <2*n ; i++) {
            arr[i]=Integer.parseInt(inputs[i]);
        }
        System.out.println(minThrow(n,arr));

    }
    static int minThrow(int N,int[]arr){
        int st=1,end=30;
        Set<Integer>snakes=new HashSet<>();
        HashMap<Integer,Integer>ladders=new HashMap<>();
        for (int i = 0; i <2*N ; i+=2) {
            if (arr[i]<arr[i+1]){
                ladders.put(arr[i],arr[i+1]);
            }else snakes.add(arr[i]);
        }
        Queue<dicethrow>q=new LinkedList<>();
        q.add(new dicethrow(st,0));
        int lastcell;
        while (!q.isEmpty()){
            dicethrow cell= q.poll();
            if (cell.pos>=end)return cell.moves;
            lastcell=cell.pos;
            for (int i = 1; i <=6 ; i++) {
                int key=cell.pos+i;
                if (snakes.contains(key))continue;
                if (ladders.containsKey(key)){
                    q.add(new dicethrow(ladders.get(key),cell.moves+1));
                }else if (key>lastcell){
                    lastcell=key;
                }
            }
            q.add(new dicethrow(lastcell,cell.moves+1));
        }
        return -1;
    }
}
class dicethrow{
    int pos;
    int moves;
    dicethrow(int pos,int moves){
        this.pos=pos;
        this.moves=moves;
    }
}

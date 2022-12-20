package com.ac;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ktsmallestinmatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][]matrix=new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                matrix[i][j]=sc.nextInt();
            }
        }
        int k=sc.nextInt();
        System.out.println(KthSmallest(matrix,k));
    }
    static int KthSmallest(int[][]matrix,int k){
        if (k==1)return matrix[0][0];
        PriorityQueue<indexwithnumber>queue=new PriorityQueue<>(new Comparator<indexwithnumber>(){
            @Override
            public int compare(indexwithnumber o1,indexwithnumber o2){
                return o1.num-o2.num;
            }
        });
        HashMap<String,Boolean>map=new HashMap<>();
        queue.add(new indexwithnumber(0,0,matrix[0][0]));
        int  num=matrix[0][0];
        map.put(0+"*"+0,true);
        while (k!=0&&!queue.isEmpty()){
            indexwithnumber o=queue.poll();
            num=o.num;
            String t=(o.i+1)+"*"+o.j;
            if (o.i+1<matrix.length&&!map.containsKey(t)){
                queue.add(new indexwithnumber(o.i+1,o.j,matrix[o.i+1][o.j]));
                map.put(t,true);
            }
            t=o.i+"*"+(o.j+1);
            if (o.j+1<matrix[0].length&&!map.containsKey(t)){
                queue.add(new indexwithnumber(o.i,o.j+1,matrix[o.i][o.j+1]));
                map.put(t,true);
            }
            k--;
        }
        return num;
    }
}

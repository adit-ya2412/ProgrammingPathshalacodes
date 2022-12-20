package com.ac;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class mergeKsortedarrays {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int[][]arr=new int[k][k];
        for (int i = 0; i <k ; i++) {
            for (int j = 0; j <k ; j++) {
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(mergeKArrays(arr,k));
    }
    static ArrayList<Integer>mergeKArrays(int[][]arr,int k){
        PriorityQueue<indexwithnumber>queue=new PriorityQueue<>(new Comparator<indexwithnumber>() {
            @Override
            public int compare(indexwithnumber o1, indexwithnumber o2) {
                return o1.num-o2.num;
            }
        });
        for (int i = 0; i <k ; i++) {
            queue.add(new indexwithnumber(i,0,arr[i][0]));
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while (queue.size()>0){
            indexwithnumber i=queue.poll();
            if (i.j+1<k){
                queue.add(new indexwithnumber(i.i,i.j+1,arr[i.i][i.j+1]));
            }
            ans.add(i.num);
        }
     return ans;
    }
}
class indexwithnumber{
    int i;
    int j;
    int num;
    indexwithnumber(int i,int j,int num){
        this.i=i;
        this.j=j;
        this.num=num;
    }
}

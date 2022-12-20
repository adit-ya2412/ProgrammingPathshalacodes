package com.ac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class priorityqueue {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][]arr=new int[n][2];
        for (int i = 0; i <n ; i++) {
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
        int k=sc.nextInt();
        int[][]answer=kClosest(arr,k);
        for(int[]i:answer){
            System.out.println(Arrays.toString(i));
        }
    }
    static int[][]kClosest(int[][]points,int k){
        PriorityQueue<int[]>queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return getdistnace(o2)-getdistnace(o1);
            }
        });
        for (int i = 0; i <points.length ; i++) {
            queue.add(points[i]);
            if (queue.size()>k)queue.poll();
        }
        int[][]result=new int[k][2];
        for (int i = 0; i <k ; i++) {
            result[i]=queue.poll();
        }
        return result;
    }
    static int getdistnace(int[]points){
        return points[0]*points[0]+points[1]*points[1];
    }
}

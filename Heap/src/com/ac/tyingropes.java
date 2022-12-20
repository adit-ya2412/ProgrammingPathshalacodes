package com.ac;

import java.beans.IntrospectionException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class tyingropes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[]arr=new long[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextLong();
        }
        System.out.println(minCost(arr,n));

    }
    static long minCost(long[]arr,int n){
        PriorityQueue<Long>queue=new PriorityQueue<>(new Comparator<Long>(){
            @Override
            public int compare(Long i, Long j){
                return (int)(i-j);
            }
        });
        for (int i = 0; i <n ; i++) {
            queue.add(arr[i]);
        }
        long sum=0;
        while (queue.size()!=1){
            long fm=queue.poll();
            long sm=queue.poll();
            sum+=fm+sm;
            queue.add(fm+sm);
        }
        return sum;
    }
}

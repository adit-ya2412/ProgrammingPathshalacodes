package com.ac;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class printklargest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(KLargest(arr,n,k));
    }
    static ArrayList<Integer> KLargest(int[]arr,int n,int k){
        PriorityQueue<Integer>queue=new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i,Integer j){
                return j-i;
            }
        });
        for (int i = 0; i < arr.length ; i++) {
            queue.add(arr[i]);
            if (queue.size()>k)queue.poll();
        }
        ArrayList<Integer>ans=new ArrayList<>();
        for (int i = 0; i <k ; i++) {
            ans.add(queue.poll());
        }
        return ans;
    }
}

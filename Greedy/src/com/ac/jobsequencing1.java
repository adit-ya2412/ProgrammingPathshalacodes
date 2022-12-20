package com.ac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class jobsequencing1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Job[]arr=new Job[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=new Job(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        System.out.println(Arrays.toString(JobScheduling(arr,n)));

    }
    static int[]JobScheduling(Job[]arr,int n){
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.profit-o1.profit;
            }
        });
        int[]slot=new int[n+1];
        int ans=0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = Math.min(n,arr[i].deadline); j >0 ; j--) {
                if (slot[j]==0){
                    slot[j]=1;
                    ans+=arr[i].profit;
                    break;
                }
            }
        }
        int cnt=0;
        for (int i = 1; i <slot.length ; i++) {
            if (slot[i]==1)cnt++;
        }
        return new int[]{cnt,ans};
    }
}
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

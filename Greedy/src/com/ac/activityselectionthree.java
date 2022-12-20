package com.ac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class activityselectionthree {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]start_time=new int[n];
        int[]end_time=new int[n];
        for (int i = 0; i <n ; i++) {
            start_time[i]=sc.nextInt();
            end_time[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(maximumactivitypossible(start_time,end_time,k));
    }
    static int maximumactivitypossible(int[]start,int[]end,int numofpe){
        int[]peoples=new int[numofpe];
        List<startandendtime>list=new ArrayList<>();
        for (int i = 0; i <start.length ; i++) {
            list.add(new startandendtime(start[i],end[i]));
        }
        int ans=0;
        Collections.sort(list,(a,b)->a.end-b.end);
        for (int i = 0; i <list.size() ; i++) {
            int max=Integer.MIN_VALUE;
            int k=-1;
            for (int j = 0; j <peoples.length ; j++) {
                if (peoples[j]<list.get(i).st){
                    k=j;
                    max=peoples[j];
                }
            }
            if (k!=-1){
              peoples[k]=list.get(i).end;
              ans++;
            }
        }
      return ans;
    }
}

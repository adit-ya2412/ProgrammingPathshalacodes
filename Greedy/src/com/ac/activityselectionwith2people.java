package com.ac;

import java.util.*;

public class activityselectionwith2people {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]start_time=new int[n];
        int[]end_time=new int[n];
        for (int i = 0; i <n ; i++) {
            start_time[i]=sc.nextInt();
            end_time[i]=sc.nextInt();
        }
        System.out.println(maximumactivitypossible(start_time,end_time));
    }
    static int maximumactivitypossible(int[]start,int[]end){
        List<startandendtime>list=new ArrayList<>();
        for (int i = 0; i <start.length ; i++) {
            list.add(new startandendtime(start[i],end[i]));
        }
        Collections.sort(list, new Comparator<startandendtime>() {
            @Override
            public int compare(startandendtime o1, startandendtime o2) {
                return o1.end-o2.end;
            }
        });
        int currend1=list.get(0).end;
        int currend2=0;
        int ans=1;
        for (int i = 1; i <list.size() ; i++) {
            if (list.get(i).st>currend1&&list.get(i).st>currend2){
                if(currend1>currend2){
                    currend1=list.get(i).end;
                    ans++;
                }else {
                    currend2=list.get(i).end;
                    ans++;
                }
            } else if (list.get(i).st>=currend1&&list.get(i).st<currend2) {
                currend1=list.get(i).end;
                ans++;
            }else if (list.get(i).st>=currend2&&list.get(i).st<currend1){
                currend2=list.get(i).end;
                ans++;
            }
        }
        return ans;
    }
}

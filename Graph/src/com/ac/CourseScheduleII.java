package com.ac;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numCourses=sc.nextInt();
        int row,col;
        //row=numCourses-1;
        col=2;
        int[][]prerequisites=new int[numCourses][col];
        for (int i = 0; i <numCourses; i++) {
            for (int j = 0; j <col ; j++) {
                prerequisites[i][j]=sc.nextInt();
            }
        }
        System.out.println(findOrder(numCourses,prerequisites));

    }
    static int[]findOrder(int numCourses,int[][]prerequisites){
        int[]indegrees=new int[numCourses];
        List<List<Integer>>adjlist=new ArrayList<>();
        int cnt=0;
        while (cnt<numCourses){
            adjlist.add(new ArrayList<>());
            cnt++;
        }
        for (int i = 0; i <prerequisites.length ; i++) {

                indegrees[prerequisites[i][0]]++;
                adjlist.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer>queue=new LinkedList<>();
        for (int i = 0; i <indegrees.length ; i++) {
            if (indegrees[i]==0)queue.add(i);
        }
        List<Integer>ans=new ArrayList<>();
        while (!queue.isEmpty()){
            int x=queue.poll();
            ans.add(x);
            for (int i = 0; i <adjlist.get(x).size() ; i++) {
                indegrees[adjlist.get(x).get(i)]--;
                if (indegrees[adjlist.get(x).get(i)]==0)queue.add(adjlist.get(x).get(i));
            }
        }
        if (ans.size()!=numCourses)return new int[]{};
        else{
            int[]a=new int[numCourses];

            for (int i = 0; i <ans.size() ; i++) {
                a[i]=ans.get(i);
            }
            return a;
        }
    }
}

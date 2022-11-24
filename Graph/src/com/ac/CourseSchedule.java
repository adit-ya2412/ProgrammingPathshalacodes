package com.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int numCourses=Integer.parseInt(br.readLine().trim());

        int[][]prerequisites=new int[numCourses][2];
        for (int i = 0; i <numCourses ; i++) {
            String[]input=(br.readLine().trim()).split("\\s+");
            for (int j = 0; j <2 ; j++) {
                prerequisites[i][j]=Integer.parseInt(input[j]);
            }
        }
        System.out.println(canFinish(numCourses,prerequisites));
    }
    static boolean canFinish(int numCourses,int[][]prerequisites){
        List<List<Integer>>adjlist=new ArrayList<>();
        int c=0;
        while (c<numCourses){
            adjlist.add(new ArrayList<>());
            c++;
        }
        int[]indegree=new int[numCourses];
        for (int i = 0; i <prerequisites.length ; i++) {
             indegree[prerequisites[i][0]]++;
             adjlist.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer>queue=new LinkedList<>();
        for (int i = 0; i <indegree.length ; i++) {
            if (indegree[i]==0)queue.add(i);
        }
        List<Integer>schedule=new ArrayList<>();
        while (!queue.isEmpty()){
            int x=queue.poll();
            schedule.add(x);
            for (int i = 0; i <adjlist.get(x).size() ; i++) {
                indegree[adjlist.get(x).get(i)]--;
                if (indegree[adjlist.get(x).get(i)]==0)queue.add(adjlist.get(x).get(i));
            }
        }
        if (schedule.size()==numCourses)return true;
        else return false;
    }
}

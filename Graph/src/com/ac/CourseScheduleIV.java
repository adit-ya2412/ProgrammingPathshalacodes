package com.ac;

import java.util.*;

public class CourseScheduleIV {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numcourses=sc.nextInt();
        int[][]preqrequisites=new int[numcourses][2];
        int q=sc.nextInt();
        int[][]queries=new int[q][2];
        for (int i = 0; i <numcourses ; i++) {
            for (int j = 0; j <2; j++) {
                preqrequisites[i][j]=sc.nextInt();
            }
        }
        for (int i = 0; i <q ; i++) {
            for (int j = 0; j <2 ; j++) {
                queries[i][j]=sc.nextInt();
            }
        }
        System.out.println(checkIfPrerequisite(numcourses,preqrequisites,queries));
    }
    static List<Boolean>checkIfPrerequisite(int numCourses,int[][]prerequisites,int[][]queries){
        List<List<Integer>>adjlist=new ArrayList<>();
        HashMap<Integer, HashSet<Integer>> maps=new HashMap<>();
        for (int i = 0; i <numCourses ; i++) {
            adjlist.add(new ArrayList<>());
            maps.put(i,new HashSet<>());
        }
        int[]indegrees=new int[numCourses];
        for (int i = 0; i <prerequisites.length ; i++) {
            adjlist.get(prerequisites[i][0]).add(prerequisites[i][1]);
            indegrees[prerequisites[i][1]]++;
        }

        Queue<Integer>queue=new LinkedList<>();
        for (int i = 0; i <indegrees.length ; i++) {
            if (indegrees[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int x=queue.poll();
            for (int i = 0; i <adjlist.get(x).size() ; i++) {
                maps.get(adjlist.get(x).get(i)).add(x);
                maps.get(adjlist.get(x).get(i)).addAll(maps.get(x));
                indegrees[adjlist.get(x).get(i)]--;
                if (indegrees[adjlist.get(x).get(i)]==0) {
                    queue.add(adjlist.get(x).get(i));
                }
            }
        }
        List<Boolean>ans=new ArrayList<>();
        for (int i = 0; i < queries.length ; i++) {
            Set<Integer>set=maps.get(queries[i][1]);
            if (set.contains(queries[i][0])){
                ans.add(true);
            }else ans.add(false);
        }
        return ans;
    }
}

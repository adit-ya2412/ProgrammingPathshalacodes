package com.ac;

import java.util.*;

public class shortestprimepath {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        System.out.println(solve(n1,n2));
//        int[]sieve=findsieve(9999);
//        System.out.println(sieve[9999]);

    }
    static int solve(int Num1,int Num2){
        int[]sieve=findsieve(9999);
        Set<Integer>set=new HashSet<>();
        int[]visited=new int[9000];

        set.add(Num1);
        visited[Num1-1000]=1;
        Queue<primedistance>queue=new LinkedList<>();
        queue.add(new primedistance(Num1,0));
        while (!queue.isEmpty()){
            primedistance adj=queue.poll();
            if (adj.num==Num2)return adj.dist;
            String num=""+adj.num;
            StringBuilder br=new StringBuilder(num);
            for (int i = 0; i <br.length() ; i++) {
                char ch= br.charAt(i);
                for (int j = 0; j <=9 ; j++) {
                    if (i==0&&j==0)continue;
                    char rep=(char)(j+'0');
                    br.setCharAt(i,rep);
                    if (sieve[Integer.parseInt(br.toString())]==0){
                        int temp=Integer.parseInt(br.toString());
                        if (visited[temp-1000]!=1){
                            visited[temp-1000]=1;
                            set.add(temp);
                            queue.add(new primedistance(temp,adj.dist+1));
                        }
                    }
                }
                br.setCharAt(i,ch);
            }
        }
        return -1;
    }
    static int[] findsieve(int num){
        int[]sieve=new int[num+1];
        for (int i = 2; i <=Math.sqrt(num) ; i++) {
            if (sieve[i]==0){
                for (int j = 2; j*i <=num ; j++) {
                    sieve[i*j]=-1;
                }
            }
        }
        return sieve;
    }
}

class primedistance{
    int num;
    int dist;
    primedistance(int num,int dist){
        this.num=num;
        this.dist=dist;
    }
}

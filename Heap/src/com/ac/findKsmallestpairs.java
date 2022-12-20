package com.ac;

import java.util.*;

public class findKsmallestpairs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int[]arr1=new int[n1];
        int[]arr2=new int[n2];
        for (int i = 0; i <n1; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i <n2; i++) {
            arr2[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        List<List<Integer>>ans=kSmallestPairs(arr1,arr2,k);
        for(List<Integer>i:ans) System.out.println(i);
    }
    static List<List<Integer>>kSmallestPairs(int[]nums1,int[]nums2,int k){
        HashMap<String,Boolean>map=new HashMap<>();
        PriorityQueue<pair>queue=new PriorityQueue<>(new Comparator<pair>(){
            @Override
            public  int compare(pair o1,pair o2){
               return (o1.v1+o1.v2)-(o2.v1+o2.v2);
            }
        });
        queue.add(new pair(0,0,nums1[0],nums2[0]));
        map.put(0+""+0,true);
        List<List<Integer>>ans=new ArrayList<>();
        while (k>0&&!queue.isEmpty()){
            pair p=queue.poll();
            List<Integer>temp=new ArrayList<>();
            temp.add(p.v1);
            temp.add(p.v2);
            ans.add(temp);
            int i=p.idx1;
            int j=p.idx2;
            String t1=i+"*"+(j+1);
            String t2=(i+1)+"*"+j;
            if (j+1< nums2.length&&!map.containsKey(t1)){
                map.put(t1,true);
                queue.add(new pair(i,j+1,nums1[i],nums2[j+1]));
            }
            if (i+1< nums1.length&&!map.containsKey(t2)){
                map.put(t2,true);
                queue.add(new pair(i+1,j,nums1[i+1],nums2[j]));
            }
            k--;
        }
        return ans;
    }
}
class pair{
    int idx1;
    int idx2;
    int v1;
    int v2;
    pair(int idx1,int idx2,int v1,int v2){
        this.idx1=idx1;
        this.idx2=idx2;
        this.v1=v1;
        this.v2=v2;
    }
}

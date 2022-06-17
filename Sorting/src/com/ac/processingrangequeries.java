package com.ac;
import   java.io.*;
import java.util.*;
public class processingrangequeries {
    public static void main(String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine().trim());
        int[]arr=new int[n];
        String[]ele=(in.readLine().trim()).split("\\s+");
        for (int i = 0; i <n ; i++) {
            arr[i]=Integer.parseInt(ele[i]);
        }
        int q=Integer.parseInt(in.readLine().trim());
        List<List<Integer>>queries=new ArrayList<>();
        for (int i = 0; i <q ; i++) {
            String[]que=(in.readLine().trim()).split("\\s+");
            List<Integer>temp=new ArrayList<>();
            for (int j = 0; j <3 ; j++) {
                temp.add(Integer.parseInt(que[j]));
            }
            queries.add(new ArrayList<>(temp));
        }
        processqueries(arr,queries,q);
        System.out.println(Arrays.toString(arr));

    }
    static void processqueries(int[]arr,List<List<Integer>>queries,int q){
        int[]zeros=new int[arr.length];
        for (int i = 0; i <q ; i++) {
            List<Integer>que=queries.get(i);
            process(zeros,que);
        }
        for (int i = zeros.length-2; i >=0 ; i--) {
            zeros[i]+=zeros[i+1];
        }
        for (int i = 0; i < arr.length ; i++) {
            arr[i]+=zeros[i];
        }

    }
    static void process(int[]zeros,List<Integer>que){
        zeros[que.get(1)]+= que.get(2);
        if (que.get(0)!=0){
            zeros[que.get(0)-1]-= que.get(2);
        }
    }
}

package com.ac;

import java.util.*;

public class Superuglynumbers {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[]arr=new int[size];
        for (int i = 0; i <size ; i++) {
            arr[i]=sc.nextInt();
        }
        int n=sc.nextInt();
        System.out.println(nthSuperUglyNumber(n,arr));
    }
    static int nthSuperUglyNumber(int n,int[]primes){
        PriorityQueue<indxwithvalues>queue=new PriorityQueue<>(new Comparator<indxwithvalues>(){
            @Override
            public int compare(indxwithvalues o1,indxwithvalues o2){
                return o1.prim*o1.value-o2.prim*o2.value;
            }
        });
        List<Integer>arr=new ArrayList<>();
        arr.add(1);
        for (int i = 0; i <primes.length ; i++) {
            queue.add(new indxwithvalues(0,primes[i],1));
        }
        while (arr.size()<n){
            indxwithvalues temp=queue.poll();
            if (temp.prim*temp.value>arr.get(arr.size()-1)){
                arr.add(temp.prim*temp.value);
            }
            queue.add(new indxwithvalues(temp.idx+1,temp.prim,arr.get(temp.idx+1)));
        }
        return arr.get(arr.size()-1);
    }
}
class indxwithvalues{
    int idx;
    int prim;
    int value;
    indxwithvalues(int idx,int prim,int value){
        this.idx=idx;
        this.prim=prim;
        this.value=value;
    }
}

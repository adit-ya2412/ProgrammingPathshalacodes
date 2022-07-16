package com.ac;

import java.util.*;

public class levelordertraversal {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int cnt=0;
        Queue<Integer>q=new LinkedList<>();
        q.add(0);
        int s=0;
        while (cnt<n){
            int x=q.peek();
            if (x!=0) {
                System.out.print(x + " ");
                cnt++;
            }
            if (s<=n){
                q.remove();
                q.add(x*10+1);
                q.add(x*10+2);
                q.add(x*10+3);
                s+=3;
             }else q.remove();
}
}
    }

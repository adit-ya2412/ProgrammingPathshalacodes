package com.ac;

import java.util.*;

public class transformAtoB {
    static List<Long>ans=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long x=sc.nextInt();
        long y=sc.nextInt();
          ans=transform(x,y);
          if (ans.isEmpty()){
              System.out.println("NO");
          }else {
              System.out.println("YES");
              System.out.println(ans.size());
              Collections.reverse(ans);
              for (long i:ans){
                  System.out.print(i+" ");
              }
          }


    }
    static List<Long> transform(long x, long targ) {
        //List<Integer> ans = new ArrayList<>();
        if (x == targ) {
            ans.add(targ);
            return ans;
        } else if (x > targ) {
            return ans;
        }
        if (transform(x * 2, targ).isEmpty()) {
            ans = transform(x * 10 + 1, targ);
            if (!ans.isEmpty()) {
                ans.add(x);
                return ans;
            }
        }else {
                //ans = transform(x * 2, targ);
                ans.add(x);
                return ans;
            }

        return ans;
    }
}

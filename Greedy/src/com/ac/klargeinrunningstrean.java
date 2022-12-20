package com.ac;

import java.util.PriorityQueue;

public class klargeinrunningstrean {
    public static void main(String[] args) {
       KthLargest obj=new KthLargest(3,new int[]{4,5,8,2});
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));

    }
}
class KthLargest {
PriorityQueue<Integer>queue=new PriorityQueue<>();
int k;
    public KthLargest(int k, int[] nums) {
      this.k=k;
      for(int i:nums){
        this.add(i);
      }
    }

    public int add(int val) {
       queue.add(val);
       if (queue.size()>k)queue.poll();
      return queue.peek();
    }
}
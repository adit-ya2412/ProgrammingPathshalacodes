package com.ac;

import java.util.PriorityQueue;

public class findmedianinfromdatastream {
    public static void main(String[] args) {
       MedianFinder obj=new MedianFinder();
       obj.addNum(1);
       obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}
class MedianFinder {
   PriorityQueue<Integer>queuefirst=new PriorityQueue<>((a,b)->(b-a));
   PriorityQueue<Integer>queuesecond=new PriorityQueue<>();
   double median;
    public MedianFinder() {
      median=0;
    }

    public void addNum(int num) {
        if (num<=median){
            if (queuefirst.size()<=queuesecond.size()){
                queuefirst.add(num);
            }else {
              int p=queuefirst.poll();
              queuefirst.add(num);
              queuesecond.add(p);
            }
            median=findMedian();
        }else {
            if (queuesecond.size()<=queuefirst.size()){
                queuesecond.add(num);
            }else {
                int p=queuesecond.poll();
                queuesecond.add(num);
                queuefirst.add(p);
            }
            median=findMedian();
        }
    }

    public double findMedian() {
           if (Math.abs(queuefirst.size()-queuesecond.size())==1){
                median=(queuefirst.size()>queuesecond.size())?queuefirst.peek():queuesecond.peek();
           }else {
               median=(queuefirst.peek()+queuesecond.peek())*(1.0)/2;
           }
           return median;
    }
}

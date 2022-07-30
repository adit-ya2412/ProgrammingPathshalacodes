package com.ac;

import java.util.HashMap;

public class LRUcache {
    public static void main(String[] args) {

    }
}
class LRUCache {
  int maxsize,currsize;
  node3 head;
  node3 tail;
  HashMap<Integer,node3>map=new HashMap<>();
    public LRUCache(int capacity) {
    maxsize=capacity;
    currsize=0;
    head=null;
    tail=null;
    }
    node3 addtotail(int key,int val){
        node3 n=new node3(key,val);
        if (tail==null){
            head=n;
            tail=n;
        }else {
            tail.next=n;
            n.prev=tail;
            tail=n;
        }
        currsize++;
        return n;
    }
     void movetotail(node3 n,int val){
        n.val=val;
        if (n==tail){
            return;
        }else if (n==head){
            head=head.next;
            head.prev=null;
        }else {
             n.prev.next=n.next;
             n.next.prev=n.prev;
        }
        tail.next=n;
        n.prev=tail;
        n.next=null;
        tail=n;
     }
     void deleteathead(){
        node3 temp=head;
        head=head.next;
        if (head!=null){
            head.prev=null;
        }else {
            tail=null;
        }
        currsize--;
     }

    public int get(int key) {
      if (!map.containsKey(key))return -1;
      node3 n=map.get(key);
      int value=n.val;
      movetotail(n,value);
      return value;

    }

    public void put(int key, int value) {
     if (map.containsKey(key)){
         node3 n=map.get(key);
         movetotail(n,value);
         return;
     }else {
         if (currsize>=maxsize){
             map.remove(head.key);
             deleteathead();
             node3 n=addtotail(key,value);
             map.put(n.key,n);
             return;
         }else {
             node3 n=addtotail(key,value);
             map.put(n.key,n);
             return;
         }
     }
    }
}
class node3{
    int val;
    int key;
    node3 next;
    node3 prev;
    node3(int key,int val){
        this.key=key;
        this.val=val;
        prev=null;
        next=null;
    }
}


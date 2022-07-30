package com.ac;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class checkforcycle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ListNode head=null;
        ListNode tail=null;
        ListNode temp;
        ListNode cycle=null;
        int cnt=0;
        while (n!=0){
            temp=new ListNode(sc.nextInt());
            if (head==null){
                head=temp;
                tail=temp;
                cnt++;
            }else {
                if (cnt==1){
                    cycle=temp;
                }
                tail.next=temp;
                tail=tail.next;
                cnt++;
            }
            n--;
        }
        tail.next=cycle;
        System.out.println(givenodewithcycle(head).val);
    }
    static boolean checkforcycle(ListNode head){
        HashMap<ListNode,Boolean>map=new HashMap<>();
        ListNode temp=head;
        while (temp!=null){
            if (map.containsKey(temp)){
                return true;
            }else {
                map.put(temp,true);
            }
            temp=temp.next;
        }
        return false;
    }
    static boolean checkforcycle1(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow)return true;
        }
        return false;
    }
    static ListNode givenodewithcycle(ListNode head){
        ListNode slow=head,fast=head;
        boolean flag=false;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                flag=true;
                break;
            }
        }
        if (flag==false)return null;
        ListNode temp=head;
//        while (true){
//            ListNode p=slow;
//            while (p!=temp){
//                p=p.next;
//                if (p==slow)break;
//            }
//            if (temp==p){
//                return temp;
//            }
//            temp=temp.next;
//        }
        while (temp!=slow){
            temp=temp.next;
            slow=slow.next;
        }
        return temp;
    }
}

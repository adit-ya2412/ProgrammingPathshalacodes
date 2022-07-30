package com.ac;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class linkedlistpairsum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ListNode head=null;
        ListNode tail=null;
        ListNode temp;
        while (n!=0){
            temp=new ListNode(sc.nextInt());
            if (head==null){
                head=temp;
                tail=temp;
            }else {
                tail.next=temp;
                tail=tail.next;
            }
            n--;
        }
        int sum=sc.nextInt();
        System.out.println(Arrays.toString(checkforpair(head,sum)));
    }
    static int[] checkforpair(ListNode head,int sum){
        HashMap<Integer,Integer>map=new HashMap<>();
        ListNode temp=head;
        while (temp!=null){
            map.put(temp.val,0);
            temp=temp.next;
        }
        temp=head;
        while (temp!=null){
            if (map.containsKey(sum-temp.val)){
                return new int[]{temp.val,sum-temp.val};
            }
            temp=temp.next;
        }
        return new int[]{-1,-1};

    }
    static ListNode middle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    static ListNode reverse(ListNode head){
        if (head==null||head.next==null)return head;
        ListNode temp=head.next;
        head.next=null;
        ListNode newhead=reverse(temp);
        temp.next=head;
        return newhead;
    }
}

package com.ac;

import java.util.Scanner;

public class swapnodesinpairs {
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
        ListNode newhead=reversepairs(head);
        while (newhead!=null){
            System.out.print(newhead.val+"-->");
            newhead=newhead.next;
        }
    }
    static ListNode reversepairs(ListNode head){
        int cnt=0;
        ListNode curr=head;
        while (curr!=null&&cnt<2){
            cnt++;
            curr=curr.next;
        }
        if (cnt<2)return head;
        curr=head;
        ListNode prev=null;
        ListNode temp;
        cnt=0;
        while (cnt<2){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            cnt++;
        }
        head.next=reversepairs(curr);
        return prev;
    }
}

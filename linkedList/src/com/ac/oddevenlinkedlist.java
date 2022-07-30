package com.ac;

import java.util.Scanner;

public class oddevenlinkedlist {
    public static void main(String[] args) {
        ListNode head=null;
        ListNode tail=null;
        ListNode temp;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while (n!=0){
            temp=new ListNode(sc.nextInt());
            if (head==null){
                head=temp;
                tail=temp;
            }else{
                tail.next=temp;
                tail=temp;
            }
            n--;
        }
        ListNode newhead=oddeven(head);
        while (newhead!=null){
            System.out.print(newhead.val+"-->");
            newhead=newhead.next;
        }
    }
    static ListNode oddeven(ListNode head){
        if (head==null)return head;
        ListNode odd=head;
        ListNode evenhead=head.next;
        ListNode even=evenhead;
        while (even!=null&&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenhead;
        return head;
    }
}

package com.ac;

import java.util.Scanner;

public class reordelist {
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
        //reorder(head);
        reorder2(head);
        temp=head;
        while (temp!=null){
            System.out.print(temp.val+"-->");
            temp=temp.next;
        }
    }
    static void reorder(ListNode head){
        if (head==null||head.next==null)return;
        ListNode temp=head;
        while (temp.next.next!=null){
            temp=temp.next;
        }

        ListNode last=temp.next;
        temp.next=null;//unlink
        temp=head.next;
        head.next=last;//link
        last.next=temp;
        reorder(temp);
    }
    static void reorder2(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode mid=slow;
        ListNode t3=mid.next;
        mid.next=null;
        ListNode newhead=reverse(t3);
        ListNode orginalhaed=head;

        ListNode temp,temp1;
        while (newhead!=null&&orginalhaed!=null){
            temp=orginalhaed.next;
            orginalhaed.next=newhead;
            temp1=newhead.next;
            newhead.next=temp;
            orginalhaed=temp;
            newhead=temp1;
        }
    }
    static ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode temp;
        while (curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}

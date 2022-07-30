package com.ac;

import java.util.Scanner;

public class ReorderList {
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
        reorder(head);
        temp=head;
        while (temp!=null){
            System.out.print(temp.val+"--->");
            temp=temp.next;
        }
    }
    static void reorder(ListNode head){
        if (head.next==null)return;
        ListNode curr=head.next;
        ListNode prev=null;
        ListNode temp;
        while (curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        head.next=prev;
    }
}

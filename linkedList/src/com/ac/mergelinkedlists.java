package com.ac;

import java.util.Scanner;

public class mergelinkedlists {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        ListNode head=null;
        ListNode head1=null;
        ListNode tail=null;
        ListNode tail1=null;
        ListNode temp;
        int n1=sc.nextInt();
        while (n1!=0){
            temp=new ListNode(sc.nextInt());
            if (head==null){
                head=temp;
                tail=temp;
            }else {
                tail.next=temp;
                tail=tail.next;
            }
            n1--;
        }
        int n2=sc.nextInt();
        while (n2!=0){
            temp=new ListNode(sc.nextInt());
            if (head1==null){
                head1=temp;
                tail1=temp;
            }else {
                tail1.next=temp;
                tail1=tail1.next;
            }
            n2--;
        }
        ListNode newhead=merge1(head,head1);
        temp=newhead;
        while (temp!=null){
            System.out.print(temp.val+"-->");
            temp=temp.next;
        }
    }
    static ListNode merge(ListNode head1,ListNode head2){
        if (head1==null)return head2;
        else if (head2==null)return head1;
        ListNode head;
        ListNode tail;
        ListNode p1=head1;
        ListNode p2=head2;
        if (head1.val<= head2.val){
            head=head1;
            tail=head1;
            p1=p1.next;
        }else {
            head=head2;
            tail=head2;
            p2=p2.next;
        }
        while (p1!=null&&p2!=null){
            if (p1.val<= p2.val){
                tail.next=p1;
                p1=p1.next;
            }else {
                tail.next=p2;
                p2=p2.next;
            }
            tail=tail.next;
        }
        if (p1!=null){
            tail.next=p1;
        }
        if (p2!=null){

            tail.next=p2;
        }
        return head;
    }
    static ListNode merge1(ListNode head1,ListNode head2){
        if (head1==null)return head2;
        if (head2==null)return head2;
        ListNode head,temp;
        if (head1.val<= head2.val){
           head =head1;
            head.next=merge(head1.next,head2);
        }else {
            head=head2;

            head.next=merge(head1,head2.next);
        }
        return head;
    }
}

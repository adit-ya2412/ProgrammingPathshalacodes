package com.ac;

import java.util.Scanner;

public class reversenodesinK {
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
            }else {
                tail.next=temp;
                tail=tail.next;
            }
            n--;
        }
        int k=sc.nextInt();
        temp=reversek(head,k);
        while (temp!=null){
            System.out.print(temp.val+"-->");
            temp=temp.next;
        }
    }
    static ListNode reversek(ListNode head,int k){
        int size=sizeoflist(head);
        return reverse(head,k,size);
    }
    static ListNode reverse(ListNode head,int k,int size){
        if (size<k)return head;
        ListNode curr=head;
        ListNode prev=null;
        ListNode temp;
        for (int i = 0; i <k ; i++) {
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        head.next=reverse(curr,k,(size-k));
        return prev;
    }
    static int sizeoflist(ListNode head){
        ListNode temp=head;
        int cnt=0;
        while (temp!=null){
            temp=temp.next;
            cnt++;
        }
        return cnt;
    }
}

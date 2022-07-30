package com.ac;

import java.util.Scanner;

public class rotaatelist {
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
        int k=sc.nextInt();
       ListNode newhead= reversek(head,k);
       while (newhead!=null){
           System.out.print(newhead.val+"-->");
           newhead=newhead.next;
       }
    }
    static ListNode reversek(ListNode head,int k){
        if (head==null)return head;
        int size=listsize(head);
        k=k%size;
        if (k==0)return head;
        int cnt=1;
        ListNode newtail=head;
        while (cnt!=size-k){
            newtail=newtail.next;
            cnt++;
        }
        ListNode temp=newtail.next;
        newtail.next=null;
        ListNode temp1=temp;
        while (temp1.next!=null){
            temp1=temp1.next;
        }
        temp1.next=head;
        return temp;
    }
    static int listsize(ListNode head){
        ListNode temp=head;
        int cnt=0;
        while (temp!=null){
            cnt++;
            temp=temp.next;
        }
        return cnt;
    }
}

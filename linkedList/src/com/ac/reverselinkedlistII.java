package com.ac;

import java.util.Scanner;

public class reverselinkedlistII {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ListNode head=null;
        ListNode tail=null;
        ListNode temp;
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
        int left=sc.nextInt();
        int right=sc.nextInt();
        reverse(head,left,right);
        temp=head;
        while (temp!=null){
            System.out.print(temp.val+"-->");
            temp=temp.next;
        }
    }
    static void reverse(ListNode head,int left,int right){
        if (head==null)return;
        ListNode curr=head;
        ListNode prev=null;
        while (left>1){
            prev=curr;
            curr=curr.next;
            left--;
            right--;
        }
        ListNode con=prev;
        ListNode  tail=curr;
        ListNode third=null;
        while (right>0){
          third=curr.next;
          curr.next=prev;
          prev=curr;
          curr=third;
          right--;
        }
        if (con!=null){
            con.next=prev;
        }else {
            head=prev;
        }
        tail.next=curr;
    }
}

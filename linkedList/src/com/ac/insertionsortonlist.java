package com.ac;

import java.util.Scanner;


public class insertionsortonlist {
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
        ListNode h=insertionsort(head);
        while (h!=null){
            System.out.print(h.val+"-->");
            h=h.next;
        }
    }
    static ListNode insertionsort(ListNode head){
        ListNode dummy=new ListNode(100);
        ListNode temp;
        while (head!=null){
          ListNode headnext=head.next;
          temp=dummy;
          while (temp.next!=null&&temp.next.val< head.val){
              temp=temp.next;
          }
          head.next=temp.next;
          temp.next=head;
          head=headnext;
        }
        return dummy.next;
    }
}

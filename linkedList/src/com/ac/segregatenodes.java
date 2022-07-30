package com.ac;

import java.util.Scanner;

public class segregatenodes {
    public static void main(String[] args) {
        Node head=null;
        Node tail=null;
        Node temp;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while (n!=0){
            temp=new Node(sc.nextInt());
            if (head==null){
                head=temp;
                tail=temp;
            }else {
                tail.next=temp;
                tail=temp;
            }
            n--;
        }
       head= segregate(head);
        while (head!=null){
            System.out.print(head.val+"-->");
            head=head.next;
        }
    }
    static Node segregate(Node head){
        Node dummy=new Node(100);
        Node temp=dummy;
        Node curr=head;
//        if (head.val%2==0) {
//            head=head.next;
//            temp.next=curr;
//            curr=head;
//            temp=temp.next;
//        }
        while (curr!=null){
            if (head.val%2==0) {
                head=head.next;
                temp.next=curr;
                curr=head;
                temp=temp.next;
            }else if (curr.next!=null&&curr.next.val%2==0){
                Node t=curr.next;
                curr.next=curr.next.next;
                temp.next=t;
                temp=temp.next;
            }else {
                curr=curr.next;
            }

        }
      temp.next=head;
        return dummy.next;
    }
}

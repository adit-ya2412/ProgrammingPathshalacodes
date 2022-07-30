package com.ac;

import java.util.LinkedList;
import java.util.Scanner;

public class middlenodeinLinkedlist {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LL head=null;
        LL tail=null;
        LL temp;
        int n=sc.nextInt();
        while (n!=0){
            int x=sc.nextInt();
            temp=new LL(x);
            if (head==null){
                head=temp;
                tail=temp;
            }else {
                tail.next=temp;
                tail=tail.next;
            }
            n--;
        }
        System.out.println(findmiddlenode(head,tail));
    }
    static int findmiddlenode(LL head,LL tail){
        LL slow=head,fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
}

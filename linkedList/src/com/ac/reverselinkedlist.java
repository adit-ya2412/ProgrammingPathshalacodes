package com.ac;

import java.util.Scanner;

public class reverselinkedlist {
    public static void main(String[] args) {
        LL head=null;
        LL tail=null;
        LL temp;
        Scanner sc=new Scanner(System.in);
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
        temp=head;
        while (temp!=null){
            System.out.print(temp.data+"--->");
            temp=temp.next;
        }
        System.out.println();
        LL newhead=reverse(head,tail);
        temp=newhead;
        while (temp!=null){
            System.out.print(temp.data+"--->");
            temp=temp.next;
        }
    }
    static LL reverse(LL head,LL tail){
        LL curr=head;
        LL prev=null;
        LL temp;
        while (curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}

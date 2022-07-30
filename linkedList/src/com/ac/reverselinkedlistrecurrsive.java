package com.ac;

import java.util.Scanner;

public class reverselinkedlistrecurrsive {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        LL head=null;
        LL tail=null;
        LL temp;
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
        LL newhead=reverse(head);
        temp=newhead;
        while (temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }

    }
    static LL reverse(LL P){
        if (P==null||P.next==null)return P;
        LL temp=P.next;
        P.next=null;
        LL newhead=reverse(temp);
        temp.next=P;
        return newhead;

    }
}

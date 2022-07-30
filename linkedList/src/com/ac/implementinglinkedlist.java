package com.ac;

import java.util.Scanner;

public class implementinglinkedlist {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        LL head=null;
        LL tail=null;
        LL temp;
        int n=sc.nextInt();
        int x;
        while (n!=0){
            x=sc.nextInt();
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
        insertnode(4,6,head,tail);
        temp=head;
        while (temp!=null){
            System.out.print(temp.data+"--->");
            temp=temp.next;
        }
    }
    static void insertnode(int index,int value,LL head,LL tail){
        LL temp=head;
        int cnt=1;
        if (index==1){
            LL newnode=new LL(value);
            LL tempnext=head;
            head=newnode;
            newnode.next=tempnext;
        }

        while (cnt!=index-1&&temp!=null){
            temp=temp.next;
            cnt++;
        }

        if (temp.next==null){
            LL newnode=new LL(value);
            LL temnext=tail;
            tail=newnode;
            newnode.next=null;
        }
        LL newnode=new LL(value);
        LL tempnext=temp.next;
        temp.next=newnode;
        newnode.next=tempnext;
    }
    static void delete(int pos,LL head,LL tail){
        LL temp=head;
        LL tempnext;
        if (pos==1){
            tempnext=head.next;
            head=tempnext;
        }
        int cnt=1;
        while (cnt!=pos-1&&temp!=null){
            temp=temp.next;
            cnt++;
        }
        if (temp.next==tail){
            tail=temp;
            temp.next=null;
        }else {
            tempnext=temp.next.next;
            temp.next=tempnext;
        }
    }
}

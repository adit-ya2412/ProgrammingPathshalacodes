package com.ac;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class clonelinkedlist1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node[]direct=new Node[5];
        int n=sc.nextInt();
        Node head=null;
        Node tail=null;
        Node temp;
        int cnt=0;
        while (n!=0){
            temp=new Node(sc.nextInt());
            if (head==null){
                head=temp;
                tail=temp;
                direct[cnt++]=temp;
            }else {
                tail.next=temp;
                tail=temp;
                direct[cnt++]=temp;
            }
            n--;
        }
        temp=head;
        cnt=5;
        int i=2;
        while (temp!=null){
            if (cnt%i==0){
                temp.random=direct[i++];
            }else cnt--;
            temp=temp.next;
        }
        temp=head;
        while (temp!=null){
            if (temp.random!=null){
                System.out.print(temp.val+"--"+temp.random.val+"--->");
            }else {
                System.out.print(temp.val+"--"+"___"+"--->");
            }
            temp=temp.next;
        }
        System.out.println("------------------------------------------------------");
        temp=clone(head);
        while (temp!=null){
            if (temp.random!=null){
                System.out.print(temp.val+"--"+temp.random.val+"--->");
            }else {
                System.out.print(temp.val+"--"+"___"+"--->");
            }
            temp=temp.next;
        }
    }
    static Node copyRandomList(Node head) {
        Node newhead=null;
        Node curr=head;
        Node prev=null;
        Node temp;
        Map<Node,Node>map=new HashMap<>();
        while(curr!=null){
            temp=new Node(curr.val);
            map.put(curr,temp);
            if(prev==null){
                newhead=temp;
                prev=temp;
            }else{
                prev.next=temp;
                prev=temp;
            }
            curr=curr.next;
        }
        Node curr1=head,curr2=newhead;
        while(curr2!=null){
            if(curr1.random!=null){
                curr2.random=map.get(curr1.random);
            }else{
                curr2.random=null;
            }
            curr1=curr1.next;
            curr2=curr2.next;
        }
        return newhead;
    }
    static Node clone(Node head){
        Node clonehead=null;
        Node temp=null;
        Node curr=head;
        Node temp1;
        while (curr!=null){
            temp=new Node(curr.val);
            if (curr==head){
                clonehead=temp;
            }
            temp1=curr.next;
            curr.next=temp;
            temp.next=temp1;
            curr=temp1;
        }
        curr=head;
        while (curr!=null){
            if (curr.random!=null){
                curr.next.random=curr.random.next;
            }else {
                curr.next.random=null;
            }
            curr=curr.next.next;
        }
        curr=clonehead;
        Node curr1=head;
        while (curr!=null&&curr.next!=null){
            temp=curr.next;
            curr.next=curr.next.next;
            curr=curr.next;
            curr1.next=temp;
            curr1=curr1.next;
        }
        if (curr1!=null){
            curr1.next=null;
        }
         return clonehead;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

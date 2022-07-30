package com.ac;

import java.util.HashMap;
import java.util.Scanner;

public class intersectionoflinkedlist {
    public static void main(String[] args) {
   Node1 head1=null;
   Node1 tail1=null;
   Node1 head2=null;
   Node1 tail2=null;
   Node1 temp;
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        while (n1!=0){
            temp=new Node1(sc.nextInt());
            if (head1==null){
                head1=temp;
                tail1=temp;
            }else {
                tail1.next=temp;
                tail1=temp;
            }
            n1--;
        }
        HashMap<Integer,Integer>m=new HashMap<>();
        m.put(1,10);
        m.clear();
        int n=sc.nextInt();
        while (n!=0) {
            temp = new Node1(sc.nextInt());
            if (head2 == null) {
                head2 = temp;
                tail2 = temp;

            } else {
                tail2.next = temp;
                tail2 = temp;
            }
            if (n==2){
                tail1.next = temp;
            }
            n--;
        }
        System.out.println(intersectPoint(head1,head2));

    }

    static int intersectPoint(Node1 head1, Node1 head2) {
        // code here
        int len1 = size(head1);
        int len2 = size(head2);
        Node1 temp1 = head1, temp2 = head2;
        if (len1 == len2) {
            while (temp1 != null) {
                if (temp1.next == temp2.next) return temp1.next.data;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return -1;
        } else {
            if (len1 > len2) {
                int diff = len1 - len2;
                while (diff != 0) {
                    temp1 = temp1.next;
                    diff--;
                }
                while (temp1 != null) {
                    if (temp1.next == temp2.next) return temp1.next.data;
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
                return -1;

            } else {
                int diff = len2 - len1;
                while (diff != 0) {
                    temp2 = temp2.next;
                    diff--;
                }
                while (temp2 != null) {
                    if (temp2.next == temp1.next) return temp2.next.data;
                    temp2 = temp2.next;
                    temp1 = temp1.next;
                }
                return -1;
            }
        }
    }

    static int size(Node1 head) {
        Node1 temp=head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            temp=temp.next;
        }
        return cnt;
    }
}
class Node1 {
    int data;
    Node1 next;
    Node1(int d)  { data = d;  next = null; }
}
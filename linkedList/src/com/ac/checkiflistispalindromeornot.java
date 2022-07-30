package com.ac;

import java.util.Scanner;

public class checkiflistispalindromeornot {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        LL head=null;
        LL tail=null;
        LL temp;
        while (n!=0){
            temp=new LL(sc.nextInt());
            if (head==null){
                head=temp;
                tail=temp;
            }else {
                tail.next=temp;
                tail=tail.next;
            }
            n--;
        }
        //System.out.println(checkifpalindrome(head));
        System.out.println(findmiddle(head).data);
    }
    static boolean checkifpalindrome(LL head){
        LL mid=findmiddle(head);
        LL middlehead=reverse(mid);
        LL first=head;
        LL second=middlehead;
        while (first!=null&&second!=null){
            if (first.data!= second.data)return false;
            first=first.next;
            second=second.next;
        }
        return true;
    }
    static LL findmiddle(LL head){
        LL slow=head,fast=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    static LL reverse(LL head){
        if (head==null||head.next==null)return head;
        LL temp=head.next;
        head.next=null;
        LL newhead=reverse(temp);
        temp.next=head;
        return newhead;
    }
}

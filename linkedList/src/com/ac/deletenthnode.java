package com.ac;

import java.util.Scanner;

public class deletenthnode {
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
        int index=sc.nextInt();
        System.out.println(delete(head,tail,index));
    }
    static int delete(LL head,LL tail,int index){
        LL fast=head;
        LL slow=head;
        int cnt=0;
        while (cnt!=index){
            fast=fast.next;
            cnt++;
        }
        if (fast==null){
            LL temp=head.next;
            head=temp;
            return head.data;
        }
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }

        return slow.next.data;
    }
}

package com.ac;

import java.util.Scanner;

public class splitlinkedlist {
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
        int k=sc.nextInt();
        ListNode[]list=split(head,k);
        for (int i = 0; i < list.length; i++) {
            temp=list[i];
            while (temp!=null){
                System.out.print(temp.val+"--->");
                temp=temp.next;
            }
            System.out.println();
        }

    }
    static ListNode[] split(ListNode head,int k){
        int cnt=0;
        ListNode temp=head;
        while (temp!=null){
            temp=temp.next;
            cnt++;
        }
        ListNode[]ans=new ListNode[k];
        int outer=cnt/k;
        if (outer==0){
            int i=0;
            temp=head;
            ListNode pr;
            while (temp!=null){
                ans[i]=temp;
                i++;
                pr=temp.next;
                temp.next=null;
                temp=pr;
            }
            return ans;
        }
        int rem=cnt%k;
        temp=head;
        ListNode prev=null;
        for (int i = 0; i <k&&temp!=null ; i++) {
          ans[i]=temp;
            for (int j = 0; j <outer+(rem>0?1:0) ; j++) {
                prev=temp;
                temp=temp.next;
            }
            prev.next=null;
            rem--;
        }
        return ans;
    }
}

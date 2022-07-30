package com.ac;

import java.util.Scanner;

public class mergeKlists {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ListNode[]list=new ListNode[n];
        int cnt=0;
        while (cnt<n){
            ListNode head=null;
            ListNode tail=null;
            ListNode temp;
            int size=sc.nextInt();
            while (size!=0){
                temp=new ListNode(sc.nextInt());
                if (head==null){
                    head=temp;
                    tail=temp;
                }else {
                    tail.next=temp;
                    tail=tail.next;
                }
                size--;
            }
            list[cnt]=head;
            cnt++;
        }
        ListNode head=mergerec(list,0,list.length-1);
        while (head!=null){
            System.out.print(head.val+"--->");
            head=head.next;
        }
    }
    static ListNode merge(ListNode[]list){
        if (list.length==0)return null;
        ListNode ans=list[0];
        for (int i = 1; i <list.length ; i++) {
         ans=merge1(ans,list[i]);
        }
        return ans;
    }
    static ListNode merge1(ListNode head1,ListNode head2){
        if (head1==null)return head2;
        if (head2==null)return head2;
        ListNode head,temp;
        if (head1.val<= head2.val){
            head =head1;
            head.next=merge1(head1.next,head2);
        }else {
            head=head2;

            head.next=merge1(head1,head2.next);
        }
        return head;
    }
    static ListNode mergerec(ListNode[]list,int st,int end){
        if (st==end)return list[st];
        int middle=st+(end-st)/2;
        ListNode head1=mergerec(list,st,middle);
        ListNode head2=mergerec(list,middle+1,end);
        return merge1(head1,head2);
    }
}

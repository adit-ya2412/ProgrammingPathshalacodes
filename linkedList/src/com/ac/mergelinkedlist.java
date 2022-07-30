package com.ac;

import java.util.Scanner;

public class mergelinkedlist {
    public static void main(String[] args) {
        ListNode head=null;
        ListNode tail=null;
        ListNode temp;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n!=0){
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
        ListNode head2=null;
        ListNode tail2=null;
        n=sc.nextInt();
        while (n!=0){
            temp=new ListNode(sc.nextInt());
            if (head2==null){
                head2=temp;
                tail2=temp;
            }else {
                tail2.next=temp;
                tail2=tail2.next;
            }
            n--;
        }
        int a=sc.nextInt();
        int b=sc.nextInt();
        ListNode headmerge=merge(head,a,b,head2);
        while (headmerge!=null){
            System.out.print(headmerge.val+"--->");
            headmerge=headmerge.next;
        }
    }
    static ListNode merge(ListNode list1,int a,int b,ListNode list2){
        ListNode pointa=null;
        ListNode pointb=list1;
        int cnt=0;
        while (cnt!=a-1){
            pointb=pointb.next;
            cnt++;
        }
        pointa=pointb;
        while (cnt<b){
            pointb=pointb.next;
             cnt++;
        }

        ListNode list2tail=list2;
        while (list2tail.next!=null){
            list2tail=list2tail.next;
        }
        pointa.next=list2;
        list2tail.next=pointb.next;
        return list1;
    }


}
 class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
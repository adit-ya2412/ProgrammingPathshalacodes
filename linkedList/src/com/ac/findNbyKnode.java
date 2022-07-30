package com.ac;

import java.util.Scanner;

public class findNbyKnode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        LL head=null;
        LL tail=null;
        LL temp=null;
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
        float k=sc.nextInt();
        System.out.println(nbyk(head,k));
    }
    static int nbyk(LL head,float k){
        int length=size(head);
        int cnt=1;
        LL temp=head;
        while (temp!=null){
            if (cnt==Math.ceil(length/k))return temp.data;
            cnt++;
            temp=temp.next;
        }
        return cnt;
    }
    static int size(LL head){
        LL temp=head;
        int cnt=0;
        while (temp!=null){
            temp=temp.next;
            cnt++;
        }
        return cnt;
    }
}

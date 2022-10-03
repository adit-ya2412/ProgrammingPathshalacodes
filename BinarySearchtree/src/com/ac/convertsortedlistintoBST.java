package com.ac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ac.Serializeanddeserialize.print;

public class convertsortedlistintoBST {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ListNode head=null;
        ListNode tail=null;
        ListNode temp;
        int n=sc.nextInt();
        while (n!=0){
            temp=new ListNode(sc.nextInt());
            if (head==null){
                head=temp;
                tail=head;
            }else {
                tail.next=temp;
                tail=temp;
            }
            n--;
        }
//        temp=head;
//        while (temp!=null){
//            System.out.print(temp.val+"-->");
//            temp=temp.next;
//        }
        TreeNode ans=sortedList(head);
        print(ans);
    }
    static TreeNode sortedList(ListNode head){
        List<Integer>ls=new ArrayList<>();
        ListNode temp=head;
        while (temp!=null){
            ls.add(temp.val);
            temp=temp.next;
        }
        return create(ls,0,ls.size()-1);
    }
    static TreeNode create(List<Integer>ls,int st,int end){
        if (st>end)return null;
        int mid=(st+(end-st)/2);
        TreeNode root=new TreeNode(ls.get(mid));
        root.left=create(ls,st,mid-1);
        root.right=create(ls,mid+1,end);
        return root;
    }
}

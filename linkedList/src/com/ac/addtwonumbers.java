package com.ac;

public class addtwonumbers {
    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        ListNode ans=new ListNode(0);
        ListNode a1=calc(l1,l2,ans);
        while (a1!=null){
            System.out.println(a1.val+"-->");
            a1=a1.next;
        }
    }
    static ListNode calc(ListNode l1,ListNode l2,ListNode ans){
        int e1,e2,sum,carry=0;
        ListNode newhead=ans;
        while(l1!=null||l2!=null){
            if(l1==null&&l2!=null){
                 sum= l2.val+carry;
                 if (sum>9){
                     sum=sum%10;
                     carry=1;
                 }else carry=0;
                ans.next=new ListNode(sum);
                ans=ans.next;
                l2=l2.next;
            }else if(l2==null &&l1!=null){
                sum= l1.val+carry;
                if (sum>9){
                    sum=sum%10;
                    carry=1;
                }else carry=0;
                ans.next=new ListNode(sum);
                ans=ans.next;
                l1=l1.next;
            }else if(carry==0){
                e1=l1.val;
                e2=l2.val;
                sum=e1+e2;
                if(e1+e2>9){
                    ans.next=new ListNode(sum%10);
                    carry=1;
                }else{
                    ans.next=new ListNode(sum);
                }
                l1=l1.next;
                l2=l2.next;
                ans=ans.next;
            }else{
                e1=l1.val;
                e2=l2.val;
                sum=e1+e2+carry;
                if(sum>9){
                    ans.next=new ListNode(sum%10);
                    carry=1;
                }else{
                    ans.next=new ListNode(sum);
                    carry=0;
                }
                l1=l1.next;
                l2=l2.next;
                ans=ans.next;
            }
        }
        if (carry==1){
            ans.next=new ListNode(1);
        }
        return newhead.next;
    }
}

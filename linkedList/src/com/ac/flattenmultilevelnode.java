package com.ac;

public class flattenmultilevelnode {
    public static void main(String[] args) {

    }
    public  static node2 flatten(node2 head){
      node2 curr=head;
      node2 temp,temp1;
      while(curr!=null){
          if(curr.child!=null){
              temp=curr.next;
              curr.next=curr.child;
              curr.child.prev=curr;
              temp1=curr.child;
              while (temp1!=null&&temp1.next!=null){
                  temp1=temp1.next;
              }
              temp1.next=temp;
              if (temp!=null)temp.prev=temp1;
              curr.child=null;
          }
          curr=curr.next;
      }
      return head;

    }
}
class node2{
     int val;
    node2 prev;
    node2 next;
    node2 child;
    node2(int val){
        this.val=val;
        prev=null;
        next=null;
        child=null;
    }
        }

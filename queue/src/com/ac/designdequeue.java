package com.ac;

import java.util.LinkedList;

public class designdequeue {
    public static void main(String[] args) {
      deque obj=new deque(4);

        obj.insertFront(9);
        System.out.println(obj.deleteLast());
        System.out.println(obj.getRear());
        System.out.println(obj.getFront());
        System.out.println(obj.getFront());
        System.out.println(obj.deleteFront());
        System.out.println(obj.insertFront(6));
        System.out.println(obj.insertLast(5));
        System.out.println(obj.insertFront(9));
        System.out.println(obj.getFront());
        System.out.println(obj.insertFront(6));


    }
}
class deque{
    int front=0 ,rear=0,size=0,cnt=0;
    int[]arr;
    deque(int k){
        arr=new int[k];
        front=0;
        rear=0;
        size=k;
    }

    public boolean insertFront(int value) {
        if (isFull())return false;
        else {
            if (cnt==0){
                arr[front]=value;
                cnt++;
                return true;
            }
            front=(front-1)%size;
            if (front<0)front+=size;
            arr[front]=value;
        }
        cnt++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())return false;
        else {
            if (cnt==0){
                arr[rear]=value;
                cnt++;
                return true;
            }
            rear=(rear+1)%size;
            arr[rear]=value;
        }

        cnt++;
        return true;
    }

    public boolean deleteFront() {
       if (isEmpty())return false;
       if (cnt==1){
           front=(front+1)%size;
           rear=front;
           cnt--;
           return true;
       }
       else {
           front=(front+1)%size;
           cnt--;
           return true;
       }
    }

    public boolean deleteLast() {
     if (isEmpty())return false;
     if(cnt==1){
         rear=(rear-1)%size;
         if (rear<0)rear+=size;
         front=rear;
         cnt--;
         return true;
     }
     else {
         rear=(rear-1)%size;
         if (rear<0)rear+=size;
         cnt--;
         return true;
     }
    }

    public int getFront() {
        if (isEmpty())return -1;
        return arr[front];
    }

    public int getRear() {
         if (isEmpty())return -1;
         return arr[rear];
    }

    public boolean isEmpty() {
     return (cnt==0);
    }

    public boolean isFull() {
     return (cnt==size);
    }
}

package com.ac;

public class designcircularqueue {
    public static void main(String[] args) {
     MyCircularQueue on=new MyCircularQueue(6);
        System.out.println(on.enQueue(6));
//        on.enQueue(2);
//        on.enQueue(3);
//        on.enQueue(4);
        System.out.println(on.Rear());
        System.out.println(on.Rear());
        System.out.println(on.deQueue());
        System.out.println(on.enQueue(5));
        System.out.println(on.Rear());
        System.out.println(on.deQueue());
        System.out.println(on.Front());
        System.out.println(on.deQueue());
        System.out.println(on.deQueue());
        System.out.println(on.deQueue());
    }
}
class MyCircularQueue {
        int cnt=0,front=0,back=-1,K;
        int[]arr;
public MyCircularQueue(int k) {
        arr=new int[k];
        K=k;
        }

public boolean enQueue(int value) {
        if(isFull())return false;
        else{
        back=(back+1)%K;
        arr[back]=value;
        cnt++;
        return true;
        }
        }

public boolean deQueue() {
        if (isEmpty())return false;
        else{
        front=(front+1)%K;
        cnt--;
        return true;
        }
        }

public int Front() {
        if (cnt==0) return -1;
        else return arr[front];
        }

public int Rear() {
        if (cnt==0)return -1;
        else return arr[back];
        }

public boolean isEmpty() {
        return (cnt==0);

        }

public boolean isFull() {
        return(cnt==K);
        }
        }

package com.example.helloworld;

public class CircularQ {
    int a[] ;
    int n;
    int front;
    int rear;
    int count;
    CircularQ(int val)
    {
        n=val;
        rear=0;
        a = new int[n];
        count = 0;
    }

    boolean isEmpty()
    {
        if(front == -1)
            return true;
        else
            return false;
    }
    void add(int val)
    {
        a[rear]=val;
        rear = (rear+1)% n;
        count++;
    }
    void delete()
    {
        a[front]=0;
        front=(front+1)%n;
        count--;
    }
    void print()
    {
        for (int elem :
                a) {
            System.out.println(elem);
        }
    }
}

package com.example.helloworld;

public class QueuesNew {
    int a[] ;
    int n;
    int front;
    int rear;
    int count;
    QueuesNew(int val)
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
        if(count == a.length)
            throw new IllegalStateException();
        a[rear++] = val;
        count++;
    }
    void delete()
    {
        /*if(front == -1)
            return;
        else
        {
            System.out.println("deleted:"+a[front++]);
            if(front==rear)
            {
                front = rear = -1;
            }
        }*/
        front++;
        count--;
    }
    void print()
    {
        for(int i = front;i<rear;i++)
            System.out.println(a[i]);
    }
}

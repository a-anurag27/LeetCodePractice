package com.example.helloworld;

import java.util.Stack;

public class StackQueue {
    /*
    int a[] ;
    int n;
    int front;
    int rear;
    int count;
    StackQueue(int val)
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
        }
        front++;
        count--;
    }
    void print()
    {
        for(int i = front;i<rear;i++)
            System.out.println(a[i]);
    }*/
    Stack<Integer> stack = new Stack<>();
    int front =0;
    int rear =0;
    void add(int a)
    {
        stack.add(a);
        rear++;
    }
    void delete()
    {
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty())
        {
            int temp1=stack.pop();
           temp.add(temp1);
        }
        temp.pop();
        while(!temp.isEmpty())
        {
            int temp1=temp.pop();
            stack.add(temp1);
        }
    }
    void print()
    {
        for(int elem : stack)
            System.out.println(elem);
    }
}

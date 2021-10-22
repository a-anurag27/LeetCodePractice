package com.example.helloworld;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Queues {
    Queue<Integer> Q = new ArrayDeque<>();
    void AddLast(int a)
    {
        Q.add(a);
    }
    void RemoveFirst()
    {
        Q.remove();
    }
    void print()
    {
        for (int a :
                Q) {
            System.out.println(a);
        }
    }
    void reverse()
    {
        Stack<Integer> S = new Stack<>();
        for (int elem :
                Q) {
            S.add(elem);
            Q.remove(elem);
        }
       while(!S.isEmpty())
        {
            Q.add(S.pop());
        }
    }
}

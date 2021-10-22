package com.example.helloworld;

import java.util.HashMap;
import java.util.Map;

public class Chaining {

    Map<Integer, LinkedList> map = new HashMap<>();
    int n = 5;
    int Hash(int val)
    {
        return val % n;
    }
    void add(int val)
    {
        int key = Hash(val);
        if(map.containsKey(key))
        {
            LinkedList temp;
            temp = map.get(key);
            temp.addLast(val);
            map.put(key,temp);
        }
        else
        {
            LinkedList temp;
            temp = new LinkedList();
            temp.addLast(val);
            map.put(key,temp);
        }
    }
    void print()
    {
        for (var val: map.entrySet()
             ) {
            System.out.print(val.getKey() + " ");
            val.getValue().print();
        }
    }
}

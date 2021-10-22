package com.example.helloworld;

import java.util.HashMap;
import java.util.Map;

public class hashmaps {
    Map<Integer,String> a = new HashMap<>();
    void put(int val,String vall)
    {
        a.put(val,vall);
    }
    String get(int val)
    {
        return a.get(val);
    }
    void print()
    {
        for (var item :
                a.entrySet()) {
            System.out.println(item.getValue());
        }
    }
}

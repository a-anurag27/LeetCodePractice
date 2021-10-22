package com.example.helloworld;

import java.util.HashMap;
import java.util.Map;

public class hasher {
    Map<String,Integer> map = new HashMap<>();
    int Hash(String s)
    {
        int hasherval = 0;
        for (char elem :
                s.toCharArray()) {
            hasherval+=elem;
        }
       return hasherval % 100;
    }
    void putter(String s)
    {
        map.put(s,Hash(s));
    }
    void print()
    {
        for (var elem :
                map.entrySet()) {
            System.out.println(elem);
        }
    }
}

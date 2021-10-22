package com.example.helloworld;

import java.util.HashMap;
import java.util.Map;

public class ProbingL {
    Map<Integer,Integer> map = new HashMap<>();
    int n =10;
    int hash(int val)
    {
        int i =0;
        boolean done = false;
        while(done == false) {
            if (!map.containsKey((val+i)%n)) {
                done = true;
                return (val + i)%n;
            } else {
                i = (i + 1) % n;
            }
        }
        return Integer.MIN_VALUE;
    }
    int hash2(int val)
    {
        int i =0;
        boolean done = false;
        while(done == false) {
            if (!map.containsKey((val+(int)Math.pow(i,2))%n)) {
                done = true;
                return (val + (int)Math.pow(i,2))%n;
            } else {
                i = (i + 1) % n;
            }
        }
        return Integer.MIN_VALUE;
    }
    int hash3(int val)
    {
        int i =0;
        boolean done = false;
        while(done == false) {
            if (!map.containsKey((val+i*hash2(val)%n))) {
                done = true;
                return (val + i*hash2(val))%n;
            }
            else {
                i = (i + 1) % n;
            }
        }
        return Integer.MIN_VALUE;
    }
    void add(int val)
    {
        int i=0;
        int key = hash3(val);
        map.put(hash(val),val);
    }
    void print()
    {
        for (var val: map.entrySet()
        ) {
            System.out.println(val);
        }
    }
}

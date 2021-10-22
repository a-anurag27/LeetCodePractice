package com.cdw.dsapart2;

public class tnode {
    public int value;
    public tnode right;
    public tnode left;
    tnode(){
        value = 0;
        left = null;
        right = null;
    }
    tnode(int val)
    {
        value=val;
    }
    @Override
    public String toString()
    {
        return "Node:"+value;
    }
}

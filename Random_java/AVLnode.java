package com.cdw.dsapart2;

public class AVLnode {
    public int value;
    public AVLnode right;
    public AVLnode left;
    int height;
    AVLnode(){
        value = 0;
        left = null;
        right = null;
    }
    AVLnode(int val)
    {
        value=val;
    }
    @Override
    public String toString()
    {
        return "Node:"+value;
    }
}

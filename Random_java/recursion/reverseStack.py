#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Aug  5 00:59:26 2020

@author: akashkumar
"""

stack = [5,3,6]
n = len(stack)
def insert(stack, ele):
    if len(stack) == 0:
        stack.append(ele)
        return
    temp = stack.pop()
    insert(stack, ele)
    stack.append(temp)
    return
        

def reverse(stack):
    if len(stack) == 1:
        return
    else:
        temp = stack.pop()
        reverse(stack)
        insert(stack, temp)
    return stack
        
print(reverse(stack))
    

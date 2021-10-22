#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Aug  5 00:52:43 2020

@author: akashkumar
"""

stack = [7,4,3,2,0,1,56,3,2,6,3]
mid = int(len(stack) / 2) + 1

def deleteMid(s, mid):
    if mid == 1:
        s.pop()
        return
    else:
        ele = s.pop()
        deleteMid(s, mid - 1)
        s.append(ele)
    return s
    
print(deleteMid(stack, mid))
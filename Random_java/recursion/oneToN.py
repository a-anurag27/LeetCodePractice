#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Aug  4 20:51:45 2020

@author: akashkumar
"""

def printOneToN(N):
    if N == 1:
        print(1, end = ' ')
        return 1
    printOneToN(N-1)
    print(N, end = ' ')
    
def printNToOne(N):
    if N == 1:
        print(N, end = ' ')
        return 1
    print(N, end = ' ')
    printNToOne(N-1)
    
printNToOne(5)
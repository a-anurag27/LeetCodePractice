#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Aug  5 00:08:15 2020

@author: akashkumar
"""
def sortedInsert(s , element): 
	if len(s) == 0 or element > s[-1]: 
		s.append(element) 
		return
	else: 
		temp = s.pop() 
		sortedInsert(s, element) 
		s.append(temp) 

def sortStack(s): 
	if len(s) != 0: 
		temp = s.pop() 
		sortStack(s) 
		sortedInsert(s , temp) 
        
def printStack(s): 
	for i in s[::-1]: 
			print(i , end=" ") 
	print() 
    
if __name__=='__main__': 
	s = [ ] 
	s.append(30) 
	s.append(-5) 
	s.append(18) 
	s.append(14) 
	s.append(-3) 
    
	printStack(s) 

	sortStack(s) 

	printStack(s) 
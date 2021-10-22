package com.example.helloworld;
import java.util.Stack;
public class Stacks {
    public String reverser( String input)
    {
        Stack<Character> stack = new Stack<>();
        String S="";
        for(int i=0; i<input.length();i++)
        {
            stack.push(input.charAt(i));
        }
        while(!stack.isEmpty())
        {
            char s =stack.pop();
            S = S+s;
        }
        return S;
    }
    public boolean BalancedParanthesis(String input)
    {
        Stack<Character> stack = new Stack<>();
        String S="";
        for(int i=0; i<input.length();i++)
        {
            if(input.charAt(i)=='(' || input.charAt(i)=='[' || input.charAt(i)=='<')
                stack.push(input.charAt(i));
            else if(input.charAt(i)==')')
            {
                if(stack.peek()=='(')
                {
                    stack.pop();
                }
            }
            else if(input.charAt(i)=='>')
            {
                if(stack.peek()=='<')
                {
                    stack.pop();
                }
            }
            else if(input.charAt(i)==']')
            {
                if(stack.peek()=='[')
                {
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}

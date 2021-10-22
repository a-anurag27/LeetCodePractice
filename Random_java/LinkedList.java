package com.example.helloworld;

public class LinkedList {
    node first;
    node last;
    int size;
    node first2;
    node last2;
    int count2;
    LinkedList(){
        first=null;
        last=null;
        size =0;
        count2=0;
    }

    void addLast(int a)
    {
        node temp = new node(a);
        if(first == null)
            first = last = temp;
        else{
            last.next= temp;
            last=temp;
        }
        size++;
    }
    void addFirst(int a)
    {
        node temp = new node(a);
        if(first==null)
        {
            first=last=temp;
        }
        else
        {
           temp.next=first;
           first=temp;
        }
    }
    public int IndexOf(int a)
    {
       node temp = first;
       int index=0;
       while(temp!=null) {
           if (temp.value == a)
               return index + 1;
           temp = temp.next;
           index++;
       }
       return -1;
    }
    public void removeFirst()
    {
        if(first==last)
        {
            first=last=null;
            return;
        }
        if(first!=null)
        {
            first=first.next;
        }
        else
        {
            System.out.println("list empty");
        }
    }
    public void removeLast()
    {
        if(first==last)
        {
            first=last=null;
            return;
        }
        if(last!=null)
        {
            node temp = first;
            if(temp.next!=last){
                temp=temp.next;
                temp.next=null;
                last=temp;
            }
            else
            {
                temp.next=null;
            }
        }
    }
    node previousNoder(node curr)
    {
        node temp = first;
        if(curr==first)
            return null;
        while(temp.next!=curr)
        {
            temp = temp.next;
        }
        return temp;
    }
    node previousnode(int val)
    {
        node temp= first;
        while(temp!=null)
        {
            if(temp.value == val)
            {
                return previousNoder(temp);
            }
            temp = temp.next;
        }
        return previousNoder(temp);
    }
    void print()
    {node temp = first;
        while(temp!=null)
        {
            System.out.println(temp.value);
            temp= temp.next;
        }
    }

    LinkedList reverse()
    {

        node temp = last;
        LinkedList templist = new LinkedList();
        while(temp!=null) {
            //System.out.println(temp.value);
            templist.addLast(temp.value);
            temp = previousNoder(temp);
        }
        return templist;
    }
    int ValueFromEnd(int num)
    {
        num--;
        node temp = last;
        while(num!=0)
        {
            temp=previousNoder(temp);
            num--;
        }
        if(temp==null)return 0;
        return temp.value;
    }
}

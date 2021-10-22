package com.cdw.dsapart2;

public class Heap {
    int[] arr = new int[10];
    int size;
    public void insert(int value)
    {
        arr[size++]=value;
        bubbleup();
    }
    public int remove()
    {
        int root = -1;
        if(size==0)
            throw new IllegalStateException();
        root = arr[0];
        arr[0] = arr[--size];
        bubbledown();
        return root;
    }
    public int[] ascarr(int [] array)
    {
        while(size!=0)
        {
            for (int i=array.length-1;i>=0;i--)
            {
                array[i] = remove();
            }
        }
        return array;
    }
    public int[] desarr(int [] array)
    {
        while(size!=0)
        {
            for (int i=0;i<array.length;i++)
            {
                array[i] = remove();
            }
        }
        return array;
    }
    void bubbledown(){
        int index =0;
        while(index<=size && !isValidParent(index))
        {
            int largerChildIndex = largerchildindex(index);
            swap(index,largerChildIndex);
            index = largerChildIndex;
        }
    }
    int[] heapify(int[] a)
    {
        for (int i :
                a) {
            insert(i);
        }
        return arr;
    }
    private int largerchildindex(int index)
    {
        if(!hasLeftChild(index))
            return (index);
        if(!hasRightChild(index))
            return leftchildindex(index);
        return (leftchild(index))>rightchild(index)?leftchildindex(index):rightchildindex(index);
    }
    boolean hasLeftChild(int index)
    {
        return ((index*2)+1)<size;
    }
    boolean hasRightChild(int index)
    {
        return ((index*2)+2)<size;
    }
    boolean isValidParent(int index)
    {
        if(!hasLeftChild(index))
            return true;
        boolean isValid = arr[index]>=leftchild(index);
        if(!hasRightChild(index))
            return isValid&=arr[index]>=rightchild(index);
        return isValid;
    }
    int leftchildindex(int index)
    {
        return (index*2)+1;
    }
    int rightchildindex(int index)
    {
        return (index*2)+2;
    }
    int leftchild(int index)
    {
        return arr[leftchildindex(index)];
    }
    int rightchild(int index)
    {
        return arr[rightchildindex(index)];
    }

    private void bubbleup()
    {
        int index= size -1;
        while(index>0 && arr[index] > arr[parent(index)])
        {
            swap(index,parent(index));
            index = parent(index);
        }
    }
    private int parent(int index)
    {
        return (index - 1)/2;
    }
    private void swap(int a,int b)
    {
        var temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    void print()
    {
        for(int i=0;i<size;i++)
            System.out.println(arr[i]);
    }
}

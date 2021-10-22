package com.cdw.dsapart2;

public class MaxHeap {
    public static void heapify(int arr[])
    {
        int size = (arr.length/2) -1;
        for(int i=size;i>=0;i--)
        {
            heapify(arr,i);
        }
    }
    public static void heapify(int arr[],int index)
    {
        int largestIndex = index;
        int leftindex = (index*2) +1;
        if(leftindex<arr.length&&arr[leftindex]>arr[largestIndex])
        {
            largestIndex = leftindex;
        }
        int rightindex=(index*2)+2;
        if(rightindex<arr.length&&arr[rightindex]>arr[largestIndex])
        {
            largestIndex=rightindex;
        }
        if(index==largestIndex)
            return;
        swap(arr,index,largestIndex);
        heapify(arr,largestIndex);
    }
    public static void swap(int arr[],int first,int second)
    {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second]=temp;
    }
    public static int getKthLargest(int [] arr,int k)
    {
        var heap = new Heap();
        for(var number : arr)
            heap.insert(number);
        for(int i=0;i<k-1;i++)
        {
            heap.remove();
        }
        return heap.arr[0];
    }
}

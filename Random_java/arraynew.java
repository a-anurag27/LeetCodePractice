package com.example.helloworld;

public class arraynew {
    public int n;
    public int curr;
    public int[] arr;
    arraynew(int no){
        n=no;
        curr=0;
        arr = new int[n];
    }
    void insert(int v){
        if(curr<n) {
            arr[curr++]=v;
        }
        if(curr>=n)
        {
            int temp[] = new int[n];
            temp = arr;
            n++;
            arr= new int[n];
            int i;
            for(i=0;i<temp.length;i++)
            {
                arr[i]=temp[i];
            }
            curr--;
            arr[curr++]=v;
        }
    }
    void print(){

        for(int i=0;i<curr;i++)
            System.out.println(arr[i]);
    }
    void delete(int p){
        p-=1;
        for(int i=0;i<curr;i++)
        {
            if(i>=p){
                arr[i]=arr[i+1];
                if(i==curr-1)
                    curr--;

            }
            else
                continue;
        }
    }
}

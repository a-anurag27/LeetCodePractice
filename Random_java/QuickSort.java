public class QuickSort {
    void sort(int arr[])
    {
        sort(arr,0,arr.length-1);
    }
    void sort(int a[],int start,int end)
    {
        if(start>=end)
            return;
        //Partition
        var boundary = partition(a,start,end);
        //Sort left
        sort(a,start,boundary-1);
        //Sort right
        sort(a,boundary+1,end);
    }
    int partition (int a[],int start,int end)
    {
        var pivot = a[end];
        var boundary = start-1;
        for( var i=start;i<=end;i++)
        {
            if(a[i]<=pivot)
                swap(a,i,++boundary);
        }
        return boundary;
    }
    void swap(int a[],int j,int j2)
    {
        var temp = a[j];
        a[j]=a[j2];
        a[j2]=temp;
    }
}

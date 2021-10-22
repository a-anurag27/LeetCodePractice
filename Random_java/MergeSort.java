public class MergeSort {
    void sort(int a[])
    {
        if(a.length<2)
            return;
        //Divide this arr to half
        var middle = a.length/2;
        int [] left = new int[middle];
        for(int i=0;i<middle;i++)
        {
            left[i] = a[i];
        }
        int[] right = new int[a.length-middle];
        for(int i= middle;i<a.length;i++) {
            right[i - middle] = a[i];
        }
        //Sort partitions
        sort(left);
        sort(right);
        //Merge two arrays
        merge(left,right,a);
    }
    void merge(int a[],int b[],int res[])
    {
        int i=0,j=0,k=0;
        while(i<a.length && j<b.length)
        {
            if(a[i]<=b[j])
                res[k++]=a[i++];
            else
                res[k++]=b[j++];
        }
        while(i<a.length)
        {
            res[k++] = a[i++];
        }
        while(j<b.length)
        {
            res[k++] = b[j++];
        }
    }
}

public class CountingSort {
    void sort(int[] arr,int max)
    {
        int [] counts = new int[max+1];
        for(var item : arr)
        {
            counts[item]++;
        }
        int k=0;
        for(var i=0;i<counts.length;i++)
            for(var j=0;j<counts[i];j++)
                arr[k++] = i;
    }
}

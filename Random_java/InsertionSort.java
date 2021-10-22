public class InsertionSort {
    void sort(int[] a)
    {
        for(int i=1;i<a.length;i++)
        {
            var curr = a[i];
            var j= i-1;
            while(j>=0&&a[j]>curr)
            {
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=curr;
        }
    }
}

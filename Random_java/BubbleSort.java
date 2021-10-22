public class BubbleSort {
    public void sort(int[] array)
    {
        for(int i= 0;i<array.length;i++)
        {
            for(int j=1;j<array.length-i;j++)
            {
                if(array[j]<array[j-1])
                {
                    //var temp = array[j];
                    //array[j]=array[j-1];
                    //array[j-1]=temp;
                    swap(array,j,j-1);
                }
            }
        }
    }
    void swap(int a[],int j,int j2)
    {
        var temp = a[j];
        a[j]=a[j2];
        a[j2]=temp;
    }
}

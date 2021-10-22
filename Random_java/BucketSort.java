import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    void sort(int arr[],int nob){
        var i=0;
        for(var bucket : createbuckets(arr,nob))
        {
            Collections.sort(bucket);
            for(var item:bucket)
                arr[i++] = item;
        }
    }
    List<List<Integer>> createbuckets(int arr[],int nob)
    {
        List<Integer> x = new ArrayList<>();
        List<List<Integer>> buckets = new ArrayList<>();
        for(var i=0;i<nob;i++)
            buckets.add(new ArrayList<>());

        for(var item : arr)
            buckets.get(item/nob).add(item);
        return buckets;
    }
}

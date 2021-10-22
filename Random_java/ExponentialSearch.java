public class ExponentialSearch {
    int search(int a[],int target)
    {
        int bound =1;
        while(bound < a.length && a[bound]<target)
            bound*=2;
        var search = new BinarySearch();
        int left = bound/2;
        int right = Math.min(bound,a.length-1);
        return search.binarysearchR(a,target,left,right);
    }
}

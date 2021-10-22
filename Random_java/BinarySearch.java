public class BinarySearch {
    public int binarysearchR(int a[],int target)
    {
        return binarysearchR(a,target,0,a.length-1);
    }
    int binarysearchR(int a[], int target, int left, int right)
    {
        if(right<left)
            return -1;
        int mid = (left + right)/2;
        if(a[mid]==target)
            return mid;
        if(target<a[mid])
            return binarysearchR(a,target,left,mid-1);
        return binarysearchR(a,target,mid+1,right);
    }
    int binarysearchI(int[] arr,int target)
    {
        var left =0;
        var right = arr.length-1;
        while(left<=right)
        {
            var mid = (left+right)/2;
            if(arr[mid]==target)
                return mid;
            if(target<arr[mid])
                right=mid-1;
            else
                left=mid+1;
        }
        return -1;
    }
}

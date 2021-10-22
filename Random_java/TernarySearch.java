public class TernarySearch {
    int search(int a[],int target)
    {
        return search(a,target,0,a.length-1);
    }
    int search(int a[],int target,int left,int right)
    {
        if(left>right)
            return -1;
        int partsize = (right-left)/3;
        int mid1 = left+partsize;
        int mid2= right-partsize;
        if(a[mid1]==target)
            return mid1;
        if(a[mid2]==target)
            return mid2;
        if(target<a[mid1])
            return search(a,target,left,mid1-1);
        if(target>a[mid2])
            return search(a,target,mid2+1,right);
        return search(a,target,mid1+1,mid2-1);
    }
}

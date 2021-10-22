public class Main {
    public static void main(String args[])
    {
        /*int[] a = {1,5,3,4,2,6,7,10};
        var sorter = new BucketSort(); //BubbleSort(),SelectionSort(),InsertionSort(),MergeSort(),QuickSort(),CountingSort()
        sorter.sort(a,8);
        for(int i:a)
            System.out.println(i);
        var Searcher = new ExponentialSearch();
        System.out.println(Searcher.search(a,7)+1);//search,binary search(r,i),ternary,Jump
        */
        String s = "hellothisistheomegawolf";
        StringUtils St = new StringUtils();
        System.out.println(St.Vowels(s));
        System.out.println(St.reverse(s));
        System.out.println(St.reverseWords("abc def ghi"));
        System.out.println(St.areRotations("ABCD","DABC"));
        System.out.println(St.removeDupes(s));
        System.out.println(St.getMaxOccurrence(s));
        System.out.println(St.capitalize("hello from the omega wolf"));
        System.out.println(St.areAnagram("ABCD","CDBA"));
        System.out.println(St.areAnagrams2("ABCD","CDBA"));
        System.out.println(St.Palindrome("MADAM"));


    }
}

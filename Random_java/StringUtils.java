import java.util.*;

public class StringUtils {
    public int Vowels(String s)
    {
        int count = 0;
        for(char c : s.toLowerCase().toCharArray())
        {
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
                count++;
        }
        return count;
    }
    public static String reverse(String str)
    {
        StringBuilder reversed = new StringBuilder();
        for(var i = str.length()-1;i>=0;i--)
        {
            reversed.append(str.charAt(i));
            //reversed+=str.charAt(i);
        }
        return reversed.toString();
    }
    public static String reverseWords(String sentence)
    {
        String[] words = sentence.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ",words);
        //StringBuilder reversed = new StringBuilder();
        //for(var i=words.length-1;i>=0;i--)
        //    reversed.append(words[i]+" ");
        //return reversed.toString().trim();
    }
    public static boolean areRotations(String str1,String str2)
    {
        return (str1.length()==str2.length()&&(str1+str1).contains(str2));
    }
    public static String removeDupes(String s)
    {
        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<Character>();
        for(var ch:s.toCharArray())
        {
            if(!seen.contains(ch))
            {
                seen.add(ch);
                output.append(ch);
            }
        }
        return output.toString();
    }
    public static char getMaxOccurrence(String s)
    {
        /*Map<Character,Integer> f = new HashMap<>();
        for(var ch:s.toCharArray()) {
            if (f.containsKey(ch))
                f.replace(ch, f.get(ch) + 1);
            else
                f.put(ch, 1);
        }*/
        final int ASCII_SIZE = 256;
        int max=0;
        int f[] = new int[ASCII_SIZE];
        char res = ' ';
        for(var ch : s.toCharArray())
            f[ch]++;
        for(var i=0;i<f.length;i++)
            if(f[i]>max) {
                max=f[i];
                res = (char) i;
            }
        return res;
    }
    public String capitalize(String sent) {
        String[] words = sent.trim().replaceAll(" +"," ").split(" ");
        for(var i=0;i<words.length;i++)
            words[i] = words[i].substring(0,1).toUpperCase()+words[i].substring(1).toLowerCase();
        return String.join(" ",words);
    }
    public boolean areAnagram(String f, String s)
    {
        var a1 = f.toLowerCase().toCharArray();
        Arrays.sort(a1);
        var a2 = s.toLowerCase().toCharArray();
        Arrays.sort(a2);
        return Arrays.equals(a1,a2);
    }
    public boolean areAnagrams2(String f,String s)
    {
        if(f==null||s==null)
            return false;
        final int ENGLISH_ALPHABET=26;
        int [] fr = new int[ENGLISH_ALPHABET];
        f = f.toLowerCase();
        for(var i=0;i<f.length();i++)
            fr[f.charAt(i)-'a']++;
        s = s.toLowerCase();
        for(var i=0;i<s.length();i++) {
            if (fr[s.charAt(i) - 'a'] == 0)
                return false;
            fr[s.charAt(i) - 'a']--;
        }
        return true;
    }
    public boolean Palindrome(String s)
    {
        //StringBuilder input = new StringBuilder();
        //input.reverse();
        //return input.toString().equals(s);
        int left = 0;
        int right = s.length()-1;
        while(left<right)
        {
            if(s.charAt(left++)!=s.charAt(right--))
            {
                return false;
            }
        }
        return true;
    }
}

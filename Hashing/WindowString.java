/*

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in linear time complexity.
Note that when the count of a character C in T is N, then the count of C in minimum window in S should be at least N.

Example :

S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC"

 Note:
If there is no such window in S that covers all characters in T, return the empty string ''.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index ).

*/

public class Solution {
    public String minWindow(String A, String B) {
        int length1=A.length(),length2=B.length();
        if(length1<length2)
        return "";
        int[] str = new int[256];
        int[] pat = new int[256];
        int start=0,index=-1,min=Integer.MAX_VALUE,count=0;
        for(int i=0;i<length2;i++)
        pat[B.charAt(i)]++;
        
        for(int i=0;i<length1;i++)
        { 
            str[A.charAt(i)]++;
      
            if (pat[A.charAt(i)] != 0 &&
                str[A.charAt(i)] <= pat[A.charAt(i)] )
                count++;
      
            if (count == length2)
            {
                while ( str[A.charAt(start)] > pat[A.charAt(start)]
                       || pat[A.charAt(start)] == 0)
                {
      
                    if (str[A.charAt(start)] > pat[A.charAt(start)])
                        str[A.charAt(start)]--;
                    start++;
                }
      
                int temp = i-start+1;
                if (min > temp)
                {
                    min = temp;
                    index = start;
                }
            }
        }
        if (index == -1)
           return "";
      
        return A.substring(index,index + min);
        
    }
}

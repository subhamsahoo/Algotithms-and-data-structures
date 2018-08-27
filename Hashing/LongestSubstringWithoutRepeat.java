/*

Given a string, 
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.

*/

public class Solution {
    public int lengthOfLongestSubstring(String A) {
         Map<Character,Integer> duplicate = new HashMap<>();
        int start=0,maxLength=0,i;
        for(i=0;i<A.length();i++)
        {
            if(duplicate.containsKey(A.charAt(i)))
            {
                if(duplicate.get(A.charAt(i))<start);
                else{
                if(i-start>maxLength)
                    maxLength=i-start;
                start=duplicate.get(A.charAt(i))+1;
            }
                duplicate.put(A.charAt(i),i);
                
            }
            else
                duplicate.put(A.charAt(i),i);
        }
        if(i-start>maxLength)
            return i-start;
        return maxLength;
    }
}

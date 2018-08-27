/*

Given a string S, find the longest palindromic substring in S.

Substring of string S:

S[i...j] where 0 <= i <= j < len(S)

Palindrome string:

A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

Incase of conflict, return the substring which occurs first ( with the least starting index ).

Example :

Input : "aaaabaaa"
Output : "aaabaaa"

*/


public class Solution {
    public String longestPalindrome(String A) {
    int max=1,start=0,end=0;
    for(int i=1;i<A.length();i++)
    {
        int left=i-1,right=i+1;
        while(left>=0&&right<A.length())
        {
            //System.out.println("odd"+left+" "+right);
            if(A.charAt(left)!=A.charAt(right))
            break;
            int temp=right-left+1;
            if(temp>max)
            {
                max=temp;
                start=left;
                end=right;
            }
            left--;
            right++;
        }
        left=i-1;
        right=i;
        while(left>=0&&right<A.length())
        {
            if(A.charAt(left)!=A.charAt(right))
            break;
            int temp=right-left+1;
            if(temp>max)
            {
                max=temp;
                start=left;
                end=right;
            }
            left--;
            right++;
        }
    }
    return A.substring(start,end+1);
    }
}

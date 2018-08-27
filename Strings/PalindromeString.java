/*

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Example:

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

*/

public class Solution {
    public int isPalindrome(String A) {
        int start=0,end=A.length()-1;
        while(start<=end)
        {
            int temp1=A.charAt(start);
            int temp2=A.charAt(end);
            int valid1=0,valid2=0;
            if(temp1>=65&&temp1<=90||temp1>=97&&temp1<=122||temp1>=48&&temp1<=57)
            valid1=1;
            if(temp2>=65&&temp2<=90||temp2>=97&&temp2<=122||temp2>=48&&temp2<=57)
            valid2=1;
            if(valid1==0)
            start++;
            if(valid2==0)
            end--;
            if(valid1==1&&valid2==1)
            {
                if(temp1>=97)
                temp1=temp1-32;
                if(temp2>=97)
                temp2=temp2-32;
                if(temp1!=temp2)
                return 0;
                start++;
                end--;
            }
        }
        return 1;
    }
}

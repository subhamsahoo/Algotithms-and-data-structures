/*

The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2,
the sequence is 11.

*/


public class Solution {
    public String countAndSay(int A) {
        StringBuilder odd = new StringBuilder("1");
        StringBuilder even = new StringBuilder();
        int start=2;
        while(start<=A)
        {
            if(start%2==0)
            {
                int length=odd.length(),count;
                for(int i=0;i<length;i++)
                {
                    count=1;
                    while(i+1<length&&odd.charAt(i)==odd.charAt(i+1))
                    {
                        count++;
                        i++;
                    }
                    even.append(String.valueOf(count));
                    even.append(odd.charAt(i));
                }
                odd.delete(0,length);
            }
            else
            {
                int length=even.length(),count;
                for(int i=0;i<length;i++)
                {
                    count=1;
                    while(i+1<length&&even.charAt(i)==even.charAt(i+1))
                    {
                        count++;
                        i++;
                    }
                    odd.append(String.valueOf(count));
                    odd.append(even.charAt(i));
                }
                even.delete(0,length);
            }
            start++;
        }
        if(A%2==0)
        return even.toString();
        else
        return odd.toString();
        
    }
}

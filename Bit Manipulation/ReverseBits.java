/*

Reverse bits of an 32 bit unsigned integer

Example 1:

x = 0,

          00000000000000000000000000000000  
=>        00000000000000000000000000000000
return 0

Example 2:

x = 3,

          00000000000000000000000000000011 
=>        11000000000000000000000000000000
return 3221225472

Since java does not have unsigned int, use long

*/

public class Solution {
    public long reverse(long a) {
    long result=0L;
    long mul=2147483648L;
    for(int i=1;i<=32;i++)
    {
        long temp = a&1;
        if(temp==1)
            result=result+mul;
        a=a/2;
        mul=mul/2;
    }
    return result;
    }
}

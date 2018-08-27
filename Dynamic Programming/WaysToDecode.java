/*

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

Example :

Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

*/

public class Solution {
    int noOfWays(int index,String s,int[] data)
    {
        if(index<s.length())
        if(s.charAt(index)=='0')
            return 0;
        if(s.length()==index+1||s.length()<=index)
            return 1;
        if(data[index]!=0)
            return data[index];
        int t1=(int)(s.charAt(index))-48,t2=(int)(s.charAt(index+1))-48;
        if(t1<3&&t2==0)
        {
            data[index]=1*noOfWays(index+2,s,data);
            return data[index];
        }
        int m1=0,m2=0;
        m1=1*noOfWays(index+1,s,data);
        if(t1<2||(t1<3&&t2<7))
            m2=1*noOfWays(index+2,s,data);
        data[index]=m1+m2;
        return data[index];
    }
    
    public int numDecodings(String A) {
        int[] data= new int[A.length()+1];
        return noOfWays(0,A,data);
    }
}

/*

Given two binary strings, return their sum (also a binary string).

Example:

a = "100"

b = "11"
Return a + b = “111”.

*/

public class Solution {
    public String addBinary(String A, String B) {
        StringBuilder result = new StringBuilder();
        int length1=A.length(),length2=B.length();
        int str1=length1-1,str2=length2-1,carry=0;
        
        while(str1>=0||str2>=0)
        {
            int temp1=0,temp2=0;
            if(str1>=0)
            temp1=A.charAt(str1)-48;
            if(str2>=0)
            temp2=B.charAt(str2)-48;
            int add=temp1+temp2+carry;
            result.append(String.valueOf(add%2));
            carry=add/2;
            str1--;
            str2--;
        }
        if(carry==1)
        result.append("1");
        if(result.length()>0)
        result.reverse();
        return result.toString();
    }
}

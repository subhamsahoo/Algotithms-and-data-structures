/*

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

Read more details about roman numerals at Roman Numeric System

Example :

Input : "XIV"
Return : 14
Input : "XX"
Output : 20

*/

public class Solution {
    public int romanToInt(String A) {
        int length=A.length(),i=0,result=0;
        while(i<length)
        {
            if(A.charAt(i)=='I')
            {
                if(i+1<length&&A.charAt(i+1)=='V')
                {
                    i++;
                    result=result+4;
                }
                else if(i+1<length&&A.charAt(i+1)=='X')
                {
                    i++;
                    result=result+9;
                }
                else
                result=result+1;
            }
            else if(A.charAt(i)=='V')
                result=result+5;
            else if(A.charAt(i)=='X')
            {
                if(i+1<length&&A.charAt(i+1)=='L')
                {
                    i++;
                    result=result+40;
                }
                else if(i+1<length&&A.charAt(i+1)=='C')
                {
                    i++;
                    result=result+90;
                }
                else
                result=result+10;
            }
            else if(A.charAt(i)=='L')
                result=result+50;
            else if(A.charAt(i)=='C')
            {
                if(i+1<length&&A.charAt(i+1)=='D')
                {
                    i++;
                    result=result+400;
                }
                else if(i+1<length&&A.charAt(i+1)=='M')
                {
                    i++;
                    result=result+900;
                }
                else
                result=result+100;
            }
                
            else if(A.charAt(i)=='D')
                result=result+500;
            else if(A.charAt(i)=='M')
                result=result+1000;
            
            i++;
        }
        return result;
    }
}

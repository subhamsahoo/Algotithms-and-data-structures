/*

Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version

Input is guaranteed to be within the range from 1 to 3999.

Example :

Input : 5
Return : "V"

Input : 14
Return : "XIV"

*/

public class Solution {
    public String intToRoman(int A) {
        StringBuilder result = new StringBuilder();
        while(A>0)
        {
            if(A>=1000)
            {
                result.append("M");
                A=A-1000;
            }
            else if(A>=500)
            {
                if(A>=900)
                {
                    result.append("CM");
                    A=A-900;
                }
                else
                {
                    result.append("D");
                    A=A-500;
                }
            }
            else if(A>=100)
            {
                if(A>=400)
                {
                    result.append("CD");
                    A=A-400;
                }
                else
                {
                    result.append("C");
                    A=A-100;
                }
            }
            else if(A>=50)
            {
                if(A>=90)
                {
                    result.append("XC");
                    A=A-90;
                }
                else
                {
                    result.append("L");
                    A=A-50;
                }
            }
            else if(A>=10)
            {
                if(A>=40)
                {
                    result.append("XL");
                    A=A-40;
                }
                else
                {
                    result.append("X");
                    A=A-10;
                }
            }
            else if(A>=5)
            {
                if(A>=9)
                {
                    result.append("IX");
                    A=A-9;
                }
                else
                {
                    result.append("V");
                    A=A-5;
                }
            }
            else if(A>=1)
            {
                if(A>=4)
                {
                    result.append("IV");
                    A=A-4;
                }
                else
                {
                    result.append("I");
                    A=A-1;
                }
            }
        }
        return result.toString();
    }
}

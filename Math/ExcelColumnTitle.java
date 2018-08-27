/*

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
	
*/


public class Solution {
    public String convertToTitle(int A) {
        StringBuilder result=new StringBuilder();
        if(A<1)
        return result.toString();
        int length=0;
        while(A>0)
        {
            int temp=A%26;
            if(temp==0)
            {
                result.append('Z');
                A=A/26;
                A--;
                length++;
            }
            else
            {
                result.append((char)(64+temp));
                A=A/26;
                length++;
            }
        }
        length--;
        A=0;
        while(A<length)
        {
            char temp=result.charAt(A);
            result.setCharAt(A,result.charAt(length));
            result.setCharAt(length,temp);
            A++;
            length--;
        }
        return result.toString();
    }
}

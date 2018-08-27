/*

Write a program to validate if the input string has redundant braces?
Return 0/1

0 -> NO
1 -> YES
Input will be always a valid expression

and operators allowed are only + , * , - , /

Example:

((a + b)) has redundant braces so answer will be 1
(a + (a + b)) doesn't have have any redundant braces so answer will be 0

*/

public class Solution {
    public int braces(String A) {
        ArrayList<Character> stack = new ArrayList<>();
        int top=-1;
        for(int i=0;i<A.length();i++)
        {
            if(A.charAt(i)=='(')
            {
                stack.add(A.charAt(i));
                top++;
            }
            else if(A.charAt(i)=='+'||A.charAt(i)=='-'||A.charAt(i)=='*'||
            A.charAt(i)=='/')
            {
                stack.add(A.charAt(i));
                top++;
            }
            else if(A.charAt(i)==')')
            {
                if(stack.get(top)=='(')
                return 1;
                while(stack.get(top)!='(')
                {
                    stack.remove(top);
                    top--;
                }
                if(stack.get(top)=='(')
                {
                    stack.remove(top);
                    top--;                    
                }
            }
        }
        return 0;
    }
}

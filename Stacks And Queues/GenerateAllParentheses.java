/*

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

*/

public class Solution {
    public int isValid(String A) {
        ArrayList<Character> result = new ArrayList<Character>();
        int top=-1;
        int size=A.length();
        for(int i=0;i<size;i++)
        {
            if(A.charAt(i)=='{'||A.charAt(i)=='['||A.charAt(i)=='(')
            {
                result.add(A.charAt(i));
                top++;
            }
            else
            {
                if(top==-1)
                return 0;
                char temp = result.get(top);
                result.remove(top);
                top--;
                if(A.charAt(i)=='}')
                {
                    if(temp!='{')
                    return 0;
                }
                else if(A.charAt(i)==']')
                {
                    if(temp!='[')
                    return 0;
                }
                else if(A.charAt(i)==')')
                {
                    if(temp!='(')
                    return 0;
                }
            }
        }
        if(top!=-1)
        return 0;
        return 1;
    }
}

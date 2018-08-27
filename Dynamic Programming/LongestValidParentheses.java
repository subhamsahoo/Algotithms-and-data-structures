/*

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

*/

public class Solution {
    public int longestValidParentheses(String A) {
        ArrayList<Integer> stack=new ArrayList();
        ArrayList<Integer> open=new ArrayList();
        int length=A.length();
        for(int i=0;i<length;i++)
        {
            if(A.charAt(i)=='(')
            {
                stack.add(0);
                open.add(stack.size()-1);
            }
            else
            {
                if(open.size()>0)
                {
                    int temp=open.size()-1;
                    int index=open.get(temp);
                    open.remove(temp);
                    stack.set(index,1);
                }
                else
                    stack.add(0);
            }
            
        }
        int result=0,max=0;
        for(int i=0;i<stack.size();i++)
        {
            if(stack.get(i)==1)
                result++;
            else
            {
                if(result>max)
                    max=result;
                result=0;
            }
        }
        if(result>max)
         max=result;
        return max*2;
        

    }
}

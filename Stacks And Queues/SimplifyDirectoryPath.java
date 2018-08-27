/*

Given an absolute path for a file (Unix-style), simplify it.

Examples:

path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
Note that absolute path always begin with ‘/’ ( root directory )
Path will not have whitespace characters.

*/


public class Solution {
    public String simplifyPath(String A) {
        ArrayList<String> stack = new ArrayList<>();
        int top=-1;
        int length=A.length(),i=0;
        while(i<length)
        {
            StringBuilder data = new StringBuilder();
            while(true)
            {
                if(i>=length)
                    break;
                if(A.charAt(i)=='/')
                {
                    i++;
                    break;
                }
                data.append(A.charAt(i));
                i++;
            }
            if(data.length()==2&&data.charAt(0)=='.'&&data.charAt(1)=='.')
            {
                if(top>-1)
                {
                    stack.remove(top);
                    top--;
                }
            }
            else if(data.length()==1&&data.charAt(0)=='.');
            else if(data.length()>0)
            {
                stack.add(data.toString());
                top++;
            }
        }
        if(top==-1)
            return "/";
        StringBuilder result= new StringBuilder();
        int current=0;
        while(current<=top)
        {
            result.append("/");
            result.append(stack.get(current));
            current++;
        }
        return result.toString();
    }
}

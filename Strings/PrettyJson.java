/*

Pretty print a json object using proper indentation.

Every inner brace should increase one indentation to the following lines.
Every close brace should decrease one indentation to the same line and the following lines.
The indents can be increased with an additional ‘\t’
Example 1:

Input : {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
Output : 
{ 
    A:"B",
    C: 
    { 
        D:"E",
        F: 
        { 
            G:"H",
            I:"J"
        } 
    } 
}
Example 2:

Input : ["foo", {"bar":["baz",null,1.0,2]}]
Output : 
[
    "foo", 
    {
        "bar":
        [
            "baz", 
            null, 
            1.0, 
            2
        ]
    }
]
[] and {} are only acceptable braces in this case.

Assume for this problem that space characters can be done away with.

Your solution should return a list of strings, where each entry corresponds to a single line. The strings should not have “\n” character in them.

*/


public class Solution {
    public ArrayList<String> prettyJSON(String A) {
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder temp = new StringBuilder();
        int tabs=0;
        int size=A.length(),i=0;
        while(i<size)
        {

            char currentChar=A.charAt(i);
            if(currentChar=='{'||currentChar=='['||currentChar=='}'||currentChar==']')
            {
                if(temp.length()>0)
                {
                    result.add(temp.toString());
                    temp.delete(0,temp.length());
                }
                if(currentChar=='{'||currentChar=='[')
                {
                    for(int k=0;k<tabs;k++)
                    temp.append('\t');
                    tabs++;
                }
                else
                {
                    tabs--;
                    for(int k=0;k<tabs;k++)
                    temp.append('\t');                    
                }
                temp.append(A.charAt(i));
                if(currentChar=='{'||currentChar=='['){
                result.add(temp.toString());
                temp.delete(0,temp.length());
                }
                i++;
            }
            else if(currentChar==',')
            {
                temp.append(A.charAt(i));
                result.add(temp.toString());
                temp.delete(0,temp.length());
                i++;
            }
            else
            {
            if(i>0&&(A.charAt(i-1)=='}'||A.charAt(i-1)==']'||A.charAt(i-1)==','||
            A.charAt(i-1)=='{'||A.charAt(i-1)=='['))
            {
                for(int k=0;k<tabs;k++)
                    temp.append('\t');
            }                
                temp.append(A.charAt(i));
                i++;
            }
            
        }
        if(temp.length()>0)
        result.add(temp.toString());
        return result;
    }
}

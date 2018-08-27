/*

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

  
  */
  
  
public class Solution {
    public int evalRPN(ArrayList<String> A) {
        int size=A.size();
        int top=-1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<size;i++)
        {
            
            char temp='1';
            if(A.get(i).length()==1)
            temp=A.get(i).charAt(0);
            if(temp=='+'||temp=='-'||temp=='*'||temp=='/')
            {
                int op2=result.get(top);
                result.remove(top);
                top--;
                int op1=result.get(top);
                result.remove(top);
                top--;
                int push=0;
                if(temp=='+')
                {
                    push=op1+op2;
                }
                else if(temp=='-')
                {
                    push=op1-op2;
                }
                else if(temp=='*')
                {
                    push=op1*op2;
                }
                else if(temp=='/')
                {
                    push=op1/op2;
                }            
                result.add(push);
                top++;
            }
            else
            {
                top++;
                result.add(Integer.parseInt(A.get(i)));
            }
        }
        return result.get(0); 
    }
}

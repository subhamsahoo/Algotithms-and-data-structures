/*

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example :

Given numerator = 1, denominator = 2, return "0.5"
Given numerator = 2, denominator = 1, return "2"
Given numerator = 2, denominator = 3, return "0.(6)"

*/

public class Solution {
    public String fractionToDecimal(int num1, int num2) {
        StringBuilder result = new StringBuilder();
        if(num1==0||num2==0)
        return "0";
        int mul=1;
        if(num1==Integer.MIN_VALUE||num1<0)
        mul=mul*-1;
        if(num2==Integer.MIN_VALUE||num2<0)
        mul=mul*-1;
        if(mul==-1)
        result.append("-");
        long A,B;
        if(num1==Integer.MIN_VALUE)
        A=2147483648L;
        else
        A=(long)Math.abs(num1);
        if(num2==Integer.MIN_VALUE)
        B=2147483648L;
        else
        B=(long)Math.abs(num2);
        if(A>=B)
        {
            result.append(String.valueOf(A/B));
            A=A%B;
        }
        if(A==0)
        return result.toString();
        if(result.length()==0||(result.length()==1&&result.charAt(0)=='-'))
        result.append("0");
        result.append(".");
        int repeat=0;
        //char start='0';
        int index=-1;
        HashMap<Long,Integer> data = new HashMap();
        while(A!=0)
        {
            if(data.containsKey(A))
            {
                repeat=1;
                index=data.get(A);
                result.insert(index,'(');
                result.append(")");
                //System.out.println(result.toString());
                return result.toString();
            }
            else
            data.put(A,result.length());
            A=A*10;
            long temp=A/B;
            A=A%B;
            result.append(String.valueOf(temp));
        }
        return result.toString();
    }
}

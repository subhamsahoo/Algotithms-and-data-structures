/*

Given two numbers represented as strings, return multiplication of the numbers as a string.

 Note: The numbers can be arbitrarily large and are non-negative.
Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer. 
For example, 
given strings "12", "10", your answer should be “120”.

NOTE : DO NOT USE BIG INTEGER LIBRARIES ( WHICH ARE AVAILABLE IN JAVA / PYTHON ). 
We will retroactively disqualify such submissions and the submissions will incur penalties.

*/

public class Solution {
    String multiplication(String num1,int mul)
    {
        int length1=num1.length()-1,carry=0,temp=0;
        StringBuilder result=new StringBuilder();
                for(int i=length1;i>=0;i--)
        {
            temp=((num1.charAt(i)-48)*mul)+carry;
           // System.out.println(temp);
            result.append(temp%10);
            carry=temp/10;
        }
        if(carry>0)
            result.append(carry);
        return result.toString();
    }
    
    
    int removePrecidingZeros(String num)
    {
        int length=num.length(),remove=-1;
        for(int i=0;i<length;i++)
        {
            if(num.charAt(i)=='0')
            remove=i;
            else
            break;
        }
        return remove;
    }
    
    public String multiply(String A, String B) {
        
        int length1=A.length()-1,length2=B.length()-1;
        if((length2==0&&B.charAt(0)=='0')||length1==0&&A.charAt(0)=='0')
            return "0";
        String num1,num2;
        int r1=removePrecidingZeros(A);
        int r2=removePrecidingZeros(B);
        num1=A.substring(r1+1,length1+1);
        num2=B.substring(r2+1,length2+1);
        length1=num1.length()-1;
        length2=num2.length()-1;
        StringBuilder result=new StringBuilder();
        int start=0;
        for(int i=length2;i>=0;i--)
        {
            int carry=0;
            String tempRes=multiplication(num1,num2.charAt(i)-48);
            //System.out.println(tempRes);
            if(result.length()==0)
                result=result.append(tempRes);
            else
            {
                int length=result.length();
                int tempLength=tempRes.length();
                int a=start,b=0;
                while(a<length||b<tempLength)
                {
                    int n1=0,n2=0;
                    if(a<length)
                        n1=result.charAt(a)-48;
                    if(b<tempLength)
                        n2=tempRes.charAt(b)-48;
                    int temp=n1+n2+carry;
                   // System.out.println(n1+" "+n2+" "+temp);
                    if(a<length)
                        result.setCharAt(a,(char)((temp%10)+48));
                    else
                        result.append(String.valueOf(temp%10));
                    carry=temp/10;
                    a++;b++;
                }
                if(carry>0)
                    result.append(carry);
            }
            start++;
        }
        result.reverse();
        return result.toString();
    }
}

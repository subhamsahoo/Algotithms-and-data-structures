/*

Find if Given number is power of 2 or not. 
More specifically, find if given number can be expressed as 2^k where k >= 1.

Input: number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)

Output:

return 1 if the number is a power of 2 else return 0

Example:

Input : 128
Output : 1

*/

public class Solution {
    public int power(String A) {
        StringBuilder previous = new StringBuilder(A);
        StringBuilder current = new StringBuilder();
        if(A.length()==1&&A.charAt(0)=='1')
        return 0;
        while(true){
        int length=previous.length(),i=0,num=0;
        if(length==1)
        {
            if(previous.charAt(0)=='1')
            return 1;
        }
        if(previous.charAt(length-1)=='2'||previous.charAt(length-1)=='4'||
        previous.charAt(length-1)=='6'||previous.charAt(length-1)=='8')
        {
        while(i<length)
        {
            num=num*10+(previous.charAt(i)-48);
            while(num<2)
            {
                i++;
                num=num*10+(previous.charAt(i)-48);
                if(current.length()>0)
                current.append("0");
            }
            current.append(String.valueOf(num/2));
            num=num%2;
            i++;
        }
        previous.delete(0,previous.length());
        previous.append(current.toString());
        current.delete(0,current.length());
        }
        else return 0;
        }
    }
}
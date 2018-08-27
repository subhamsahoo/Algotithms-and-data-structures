/*

Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

Example :

Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Output : 4

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        long number=0L;
        long mul=1L,count1=0,length=A.size();
        for(int i=0;i<32;i++)
        {
            count1=0;
            for(int j=0;j<length;j++)
            {
                long temp=A.get(j)&mul;
                if(temp==mul)
                count1++;
            }
            if(count1%3==1)
                number=number+mul;
            mul=mul*2;
        }
        if(number>2147483647)
        {
            number=number-mul;
            return (int)number;
        }
        return (int)number;
    }
}

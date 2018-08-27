/*

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
There might be multiple gray code sequences possible for a given n.
Return any such sequence.

*/


public class Solution {
    public ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> result=new ArrayList();
        if(a<0)
            return result;
        result.add(0);
        int mul=1;
        for(int i=1;i<=a;i++)
        {
            for(int j=result.size()-1;j>=0;j--)
                result.add(result.get(j)+mul);
            mul=mul*2;
        }
        return result;
    }
}

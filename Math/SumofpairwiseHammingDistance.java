/*

Hamming distance between two non-negative integers is defined as the number of positions at which the corresponding bits are different.

For example,

HammingDistance(2, 7) = 2, as only the first and the third bit differs in the binary representation of 2 (010) and 7 (111).

Given an array of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array.
Return the answer modulo 1000000007.

Example

Let f(x, y) be the hamming distance defined above.

A=[2, 4, 6]

We return,
f(2, 2) + f(2, 4) + f(2, 6) + 
f(4, 2) + f(4, 4) + f(4, 6) +
f(6, 2) + f(6, 4) + f(6, 6) = 

0 + 2 + 1
2 + 0 + 1
1 + 1 + 0 = 8

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int hammingDistance(final List<Integer> B) {
long count0,count1,greaterThan0;
        long result=0L;
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<B.size();i++)
        A.add(B.get(i));
        for(int i=0;i<32;i++)
        {
            count0=0L;
            count1=0L;
            greaterThan0=0;
            for(int j=0;j<A.size();j++)
            {
                if(A.get(j)%2==0)
                count0++;
                else
                count1++;
                int temp=A.get(j)>>1;
                if(temp>0)
                    greaterThan0=1;
                A.set(j,temp);
                
            }
            result=(result+(2*count0*count1))%1000000007;
            if(greaterThan0==0)
            return (int)result;
        }
        return (int)result;
    }
}

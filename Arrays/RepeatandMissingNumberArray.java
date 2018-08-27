/*

You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4

*/


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        long sumA=0,sumA2=0,actualA=0,actualA2=0;
        long n=A.size();
        sumA=(n*(n+1))/2;
        sumA2=(n*(n+1)*(2*n+1)/6);
        for(int i=0;i<n;i++)
        {
            long temp=A.get(i);
            actualA=actualA+temp;
            actualA2=actualA2+(temp*temp);
        }
        long diff2=actualA2-sumA2;
        long diff1=actualA-sumA;
        long dup=(((diff2/diff1)+diff1))/2;
        long missing=dup-diff1;
        ArrayList<Integer> result = new ArrayList<>();
        result.add((int)dup);
        result.add((int)missing);
        return result;
    }
}

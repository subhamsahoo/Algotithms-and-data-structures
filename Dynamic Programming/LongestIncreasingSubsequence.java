/*

Find the longest increasing subsequence of a given sequence / array.

In other words, find a subsequence of array in which the subsequence’s elements are in strictly increasing order, and in which the subsequence is as long as possible. 
This subsequence is not necessarily contiguous, or unique.
In this case, we only care about the length of the longest increasing subsequence.

Example :

Input : [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
Output : 6
The sequence : [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lis(final List<Integer> A) {
        if(A.size()<1)
        return 0;
        int[] increasing=new int[A.size()];
        increasing[0]=1;
        for(int i=1;i<A.size();i++)
        {
            int temp=0;
            for(int j=i-1;j>=0;j--)
            {
                if(A.get(i)>A.get(j))
                {
                    if(increasing[j]>temp)
                    temp=increasing[j];
                }
            }
            increasing[i]=temp+1;
        }
        int max=0;
        for(int i=0;i<A.size();i++)
        {
            if(increasing[i]>max)
            max=increasing[i];
        }
        return max;
    }
}

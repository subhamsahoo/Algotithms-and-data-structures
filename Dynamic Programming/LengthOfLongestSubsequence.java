/*

Given an array of integers, find the length of longest subsequence which is first increasing then decreasing.

**Example: **

For the given array [1 11 2 10 4 5 2 1]

Longest subsequence is [1 2 10 4 2 1]

Return value 6

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestSubsequenceLength(final List<Integer> A) {
        if(A.size()<1)
        return 0;
        int[] increasing=new int[A.size()];
        int[] decreasing=new int[A.size()];
        increasing[0]=1;
        decreasing[A.size()-1]=1;
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
        
        for(int i=A.size()-2;i>=0;i--)
        {
            int temp=0;
            for(int j=i+1;j<A.size();j++)
            {
                if(A.get(i)>A.get(j))
                {
                    if(decreasing[j]>temp)
                    temp=decreasing[j];
                }
            }
            decreasing[i]=temp+1;
        }
        
       /* for(int i=0;i<A.size();i++)
        System.out.print(increasing[i]+" ");
        
        System.out.println();
        
        for(int i=0;i<A.size();i++)
        System.out.print(decreasing[i]+" ");*/
        
        int max=0;
        for(int i=0;i<A.size();i++)
        {
            int temp=increasing[i]+decreasing[i];
            if(temp>max)
            max=temp;
        }
        
        return max-1;
    }
}

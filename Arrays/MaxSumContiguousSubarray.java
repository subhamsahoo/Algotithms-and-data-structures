/*

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example:

Given the array [-2,1,-3,4,-1,2,1,-5,4],

the contiguous subarray [4,-1,2,1] has the largest sum = 6.

For this problem, return the maximum sum.

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {
        int result=A.get(0),length=A.size(),current=A.get(0);
        for(int i=1;i<length;i++)
        {
            current=Math.max(A.get(i),current+A.get(i));
            if(current>result)
                result=current;
        }
        return result;
    }
}

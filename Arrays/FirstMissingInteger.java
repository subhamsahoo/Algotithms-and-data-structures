/*

Given an unsorted integer array, find the first missing positive integer.

Example:

Given [1,2,0] return 3,

[3,4,-1,1] return 2,

[-8, -7, -6] returns 1

Your algorithm should run in O(n) time and use constant space.

*/

public class Solution {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int size=A.size();
        if(size==0)
        return 1;
        for(int i=0;i<size;i++)
        {
            while(A.get(i)>0&&A.get(i)<=size)
            {
                if(A.get(i)!=i+1)
                {
                    int temp=A.get(A.get(i)-1);
                    if(temp==A.get(i))
                    break;
                    A.set(A.get(i)-1,A.get(i));
                    A.set(i,temp);
                }
                else
                break;
            }
        }
        int result=1;
        for(int i=0;i<size;i++,result++)
        if(A.get(i)!=result)
        return result;
        return result;
    }
}

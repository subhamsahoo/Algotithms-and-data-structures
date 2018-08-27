/*

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers.

Assume that there will only be one solution

Example: 
given array S = {-1 2 1 -4}, 
and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)

*/

public class Solution {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        if(A.size()<3)
        return Integer.MAX_VALUE;
        Collections.sort(A);
        int result=A.get(0)+A.get(1)+A.get(2);
        for(int i=0;i<A.size()-2;i++)
        {
            int start=i+1,end=A.size()-1;
            while(start<end)
            {
                int temp=A.get(i)+A.get(start)+A.get(end);
                if(Math.abs(B-temp)<Math.abs(B-result))
                result=temp;
                if(temp<B)
                start++;
                else
                end--;
                if(temp==B)
                return temp;
            }
        }
        return result;
    }
}

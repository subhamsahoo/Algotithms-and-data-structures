/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return 1 ( true ).

A = [3,2,1,0,4], return 0 ( false ).

Return 0/1 for this problem

*/

public class Solution {
    public int canJump(ArrayList<Integer> A) {
            int right=A.size()-1;
        for(int i=right-1;i>=0;i--)
        {
            if(i+A.get(i)>=right)
                right=i;
        }
        if(right==0)
            return 1;
        return 0;
    }
}

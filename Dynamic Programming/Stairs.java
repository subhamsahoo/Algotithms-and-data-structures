/*

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example :

Input : 3
Return : 3

Steps : [1 1 1], [1 2], [2 1]

*/

public class Solution {
    int findSteps(int[] data,int n)
    {
        if(n==0||n==1)
            return 1;
        if(data[n]!=0)
            return data[n];
        data[n]=findSteps(data,n-1)+findSteps(data,n-2);
        return data[n];
    }
    public int climbStairs(int A) {
        int[] data=new int[A+1];
        return findSteps(data,A);
    }
}

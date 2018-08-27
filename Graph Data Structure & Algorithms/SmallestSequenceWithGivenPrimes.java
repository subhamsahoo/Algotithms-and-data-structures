/*

Given three prime number(p1, p2, p3) and an integer k. Find the first(smallest) k integers which have only p1, p2, p3 or a combination of them as their prime factors.

Example:

Input : 
Prime numbers : [2,3,5] 
k : 5

If primes are given as p1=2, p2=3 and p3=5 and k is given as 5, then the sequence of first 5 integers will be: 

Output: 
{2,3,4,5,6}

Explanation : 
4 = p1 * p1 ( 2 * 2 )
6 = p1 * p2 ( 2 * 3 )

Note: The sequence should be sorted in ascending order

*/

public class Solution {
    public ArrayList<Integer> solve(int A, int B, int C, int D) {
        int count=1;
        ArrayList<Integer> result=new ArrayList<>();
        if(D==0)
        return result;
        int[] nums=new int[]{A,B,C};
        Arrays.sort(nums);
        result.add(nums[0]);
        int start=nums[0]+1;
        while(count<D)
        {
            int temp=start;
            while(temp%nums[0]==0)
            temp=temp/nums[0];
            while(temp%nums[1]==0)
            temp=temp/nums[1];
            while(temp%nums[2]==0)
            temp=temp/nums[2];
            if(temp==1){
            result.add(start);
            count++;
            }
            start++;
        }
        return result;
    }
}

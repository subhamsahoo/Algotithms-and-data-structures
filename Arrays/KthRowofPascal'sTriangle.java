/*

Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]
 NOTE : k is 0 based. k = 0, corresponds to the row [1]. 
 
 */
 
 public class Solution {
    public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<=A;i++)
        {
            result.add(0);
        }
        int temp=1,num=A,dem=1;
        for(int i=1;i<=(A/2);i++)
        {
            temp=temp*(num--)/(dem++);
            result.set(i,temp);
            result.set(A-i,temp);
        }
        result.set(0,1);
        result.set(A,1);
        return result;
        
    }
}

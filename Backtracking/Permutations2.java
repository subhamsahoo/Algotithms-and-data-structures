/*

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        permutations(nums,result,0);
        return result;
    }
        void permutations(int[] A,List<List<Integer>> result,int len)
    {
        if(A.length==len)
        {
            List<Integer> temp=new ArrayList();
            for(int i=0;i<A.length;i++)
                temp.add(A[i]);
            result.add(temp);
        }
        else
        {
            for(int i=len;i<A.length;i++)
            {
                if(i==len)
                    permutations(A,result,len+1);
                else
                {
                if(A[i]!=A[len]&&A[i]!=A[i-1]){
                int temp=A[i];
                for(int j=i;j>len;j--)
                    A[j]=A[j-1];
                A[len]=temp;
                permutations(A,result,len+1);
                temp=A[len];
                for(int j=len;j<i;j++)
                    A[j]=A[j+1];
                A[i]=temp;
                }
                }
            }
        }
    }

}
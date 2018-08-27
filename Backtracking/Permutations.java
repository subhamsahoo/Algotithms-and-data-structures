/*

Given a collection of numbers, return all possible permutations.

Example:

[1,2,3] will have the following permutations:

[1,2,3]
[1,3,2]
[2,1,3] 
[2,3,1] 
[3,1,2] 
[3,2,1]

*/

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        Collections.sort(A);
        permutations(A,result,0);
        return result;
    }
    
    void permutations(ArrayList<Integer> A,ArrayList<ArrayList<Integer>> result,int len)
    {
        if(A.size()==len)
            result.add(new ArrayList<Integer>(A));
        else
        {
            for(int i=len;i<A.size();i++)
            {
                if(i!=len)
                {
                int temp=A.get(i);
                A.set(i,A.get(len));
                A.set(len,temp);
                }
                permutations(A,result,len+1);
                if(i!=len)
                {
                int temp=A.get(i);
                A.set(i,A.get(len));
                A.set(len,temp);
                }
            }
        }
    }
}

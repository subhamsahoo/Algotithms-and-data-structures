/*

Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]

*/


public class Solution {
    void allSubsets(int A,int B,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> sub,int p)
    {
        if(sub.size()<=B)
        {
        if(sub.size()==B)
        result.add(new ArrayList<>(sub));
        for(int i=p;i<A;i++)
        {
            sub.add(i+1);
            allSubsets(A,B,result,sub,i+1);
            sub.remove(sub.size()-1);
        }
        }
    }
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        ArrayList<Integer> sub = new ArrayList();
        allSubsets(A,B,result,sub,0);
        return result;
    }
}

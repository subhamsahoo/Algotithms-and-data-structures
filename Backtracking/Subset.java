/*

Given a set of distinct integers, S, return all possible subsets.

 Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
Example :

If S = [1,2,3], a solution is:

[
  [],
  [1],
  [1, 2],
  [1, 2, 3],
  [1, 3],
  [2],
  [2, 3],
  [3],
]

*/


public class Solution {
     void allSubsets(ArrayList<Integer> A,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> sub,int p)
    {
        
        result.add(new ArrayList<>(sub));
        for(int i=p;i<A.size();i++)
        {
            sub.add(A.get(i));
           // System.out.println(i+1);
            allSubsets(A,result,sub,i+1);
            sub.remove(sub.size()-1);
        }
    }
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
         ArrayList<ArrayList<Integer>> result = new ArrayList();
        ArrayList<Integer> sub = new ArrayList();
        allSubsets(A,result,sub,0);
        return result;
    }
}

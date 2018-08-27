/*

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

 Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Example :

Given candidate set 10,1,2,7,6,1,5 and target 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]

*/


public class Solution {
        void allSubsets(ArrayList<Integer> A,int sum,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> sub,int p,int currentSum)
    {
        if(currentSum==sum)
        result.add(new ArrayList<>(sub));
        for(int i=p;i<A.size();i++)
        {
            if(i==p||A.get(i)!=A.get(i-1)){
            sub.add(A.get(i));
            currentSum=currentSum+A.get(i);
            allSubsets(A,sum,result,sub,i+1,currentSum);
            currentSum=currentSum-A.get(i);
            sub.remove(sub.size()-1);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        Collections.sort(a);
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        ArrayList<Integer> sub = new ArrayList();
        allSubsets(a,b,result,sub,0,0);
        return result;
    }
}

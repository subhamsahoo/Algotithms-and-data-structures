/*

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:

 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
(-1, 0, 1)
(-1, -1, 2) 

*/

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
        Collections.sort(A);
        for(int i=0;i<A.size()-2;)
        {
            int start=i+1,end=A.size()-1;
            while(start<end)
            {
                int temp=A.get(i)+A.get(start)+A.get(end);
                if(temp==0)
                {
                    ArrayList<Integer> res = new ArrayList<>();
                    res.add(A.get(i));
                    res.add(A.get(start));
                    res.add(A.get(end));
                    result.add(res);
                    while(start<end&&res.get(1)==A.get(start))
                    start++;
                    while(start<end&&res.get(2)==A.get(end))
                    end--;
                }
                else if(temp>0)
                end--;
                else
                start++;
            }
            int temp=A.get(i);
            while(i<A.size()&&temp==A.get(i))
            i++;
        }
        return result;
    }
}

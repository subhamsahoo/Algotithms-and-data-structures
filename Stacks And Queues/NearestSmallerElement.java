/*

Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that 
    j is maximum possible AND 
    j < i AND
    A[j] < A[i]
Elements for which no smaller element exist, consider next smaller element as -1.

Example:

Input : A : [4, 5, 2, 10, 8]
Return : [-1, 4, -1, 2, 2]

Example 2:

Input : A : [3, 2, 1]
Return : [-1, -1, -1]


*/


public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> data = new Stack<>();
        for(int i=0;i<A.size();i++)
        {
            if(data.empty())
            {
                result.add(-1);
                data.push(A.get(i));
            }
            else
            {
                while(data.empty()==false&&data.peek()>=A.get(i))
                    data.pop();
                if(data.empty())
                result.add(-1);
                else
                result.add(data.peek());
                data.push(A.get(i));
            }
        }
        return result;
    }
}

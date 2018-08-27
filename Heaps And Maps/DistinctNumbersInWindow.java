/*

You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.

Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

Note:

If K > N, return empty array.
For example,

A=[1, 2, 1, 3, 4, 3] and K = 3

All windows of size K are

[1, 2, 1]
[2, 1, 3]
[1, 3, 4]
[3, 4, 3]

So, we return an array [2, 3, 3, 2].

*/

public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        int length=A.size();
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer,Integer> distinct = new HashMap<>();
        if(length<B)
        return result;
        for(int i=0;i<B;i++)
        {
            if(distinct.containsKey(A.get(i)))
            distinct.put(A.get(i),distinct.get(A.get(i))+1);
            else
            distinct.put(A.get(i),1);
        }
        result.add(distinct.size());
        int previous=0;
        for(int i=B;i<length;i++)
        {
            int temp=distinct.get(A.get(previous));
            if(temp>1)
            distinct.put(A.get(previous),temp-1);
            else
            distinct.remove(A.get(previous));
            
            if(distinct.containsKey(A.get(i)))
            distinct.put(A.get(i),distinct.get(A.get(i))+1);
            else
            distinct.put(A.get(i),1);
            
            result.add(distinct.size());
            previous++;
        }
        
        return result;
    }
}

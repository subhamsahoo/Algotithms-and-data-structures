/*


Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.

Example:

		
Input: 	

1 2 3
4 5 6
7 8 9

Return the following :

[ 
  [1],
  [2, 4],
  [3, 5, 7],
  [6, 8],
  [9]
]


Input : 
1 2
3 4

Return the following  : 

[
  [1],
  [2, 3],
  [4]
]


*/


public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int size=A.size();
        if(size==0)
        return result;
        for(int i=1;i<2*size;i++)
        {
            result.add(new ArrayList<Integer>());
        }
        int start=0,end=0,resultCounter=0;
        for(int i=1;i<=size;i++)
        {
            while(start<=resultCounter && end >=0)
            {
                result.get(resultCounter).add(A.get(start).get(end));
                end--;
                start++;
            }
            end=start;
            start=0;
            resultCounter++;
        }
        start=1;end=size-1;
        for(int i=1;i<A.size();i++)
        {
            while(start<size&&end>0)
            {
                result.get(resultCounter).add(A.get(start).get(end));
                start++;
                end--;
            }
            start=end+2;
            end=size-1;
            resultCounter++;
        }
        
        return result;
    }
}


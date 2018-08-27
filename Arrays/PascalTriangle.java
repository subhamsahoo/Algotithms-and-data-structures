/*

Given numRows, generate the first numRows of Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Given numRows = 5,

Return

[
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
]

*/

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(A==0)
        return result;
        int count=1;
        for(int i=0;i<A;i++)
        {
            result.add(new ArrayList<Integer>());
            for(int j=0;j<count;j++)
            {
                result.get(i).add(0);
            }
            count++;
        }
        
        for(int i=0;i<A;i++)
    {
        for(int j=0;j<=i;j++)
        {
            if(j==0||j==i)
                result.get(i).set(j,1);
            else
                result.get(i).set(j,result.get(i-1).get(j)+result.get(i-1).get(j-1));
        }
    }
        return result;
    }
}

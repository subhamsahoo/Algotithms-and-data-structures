/*

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time. 
Example :

Input : 

    [  1 3 2
       4 3 1
       5 6 1
    ]

Output : 8
     1 -> 3 -> 2 -> 1 -> 1

	 
*/

public class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int row=A.size(),col=A.get(0).size();
        int[][] cache=new int[row][col];
        cache[row-1][col-1]=A.get(row-1).get(col-1);
        for(int i=col-2;i>=0;i--)
        cache[row-1][i]=A.get(row-1).get(i)+cache[row-1][i+1];
        for(int i=row-2;i>=0;i--)
        cache[i][col-1]=A.get(i).get(col-1)+cache[i+1][col-1];
        for(int i=row-2;i>=0;i--)
            for(int j=col-2;j>=0;j--)
                cache[i][j]=A.get(i).get(j)+Math.min(cache[i+1][j],cache[i][j+1]);
        return cache[0][0];
    }
}

/*

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 

*/

public class Solution {
    
    int minPath(ArrayList<ArrayList<Integer>> a,int row,int col,int lastRow,int[][] data)
    {
        if(data[row][col]!=Integer.MAX_VALUE)
            return data[row][col];
        if(row==lastRow-1)
        {
            data[row][col]=a.get(row).get(col);
            return data[row][col];
        }
        int m1=minPath(a,row+1,col,lastRow,data);
        int m2=minPath(a,row+1,col+1,lastRow,data);
        data[row][col]=a.get(row).get(col)+Math.min(m1,m2);
        return data[row][col];
    }
    
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int length=a.size();
        int[][] data = new int[length][length];
        for(int i=0;i<length;i++)
        {
            for(int j=0;j<length;j++)
                data[i][j]=Integer.MAX_VALUE;
        }
        return minPath(a,0,0,length,data);
    }
}

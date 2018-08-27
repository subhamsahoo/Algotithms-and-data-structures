/*

Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Example :
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

 Note: m and n will be at most 100. 
 
 */
 
 public class Solution {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int row=A.size(),col=A.get(0).size();
        int[][] cache=new int[row][col];
        if(A.get(row-1).get(col-1)==0)
        cache[row-1][col-1]=1;
        else
        return 0;
        for(int i=col-2;i>=0;i--)
            if(A.get(row-1).get(i)==0)
                cache[row-1][i]=cache[row-1][i+1];
        for(int i=row-2;i>=0;i--)
            if(A.get(i).get(col-1)==0)
                cache[i][col-1]=cache[i+1][col-1];
        for(int i=row-2;i>=0;i--)
            for(int j=col-2;j>=0;j--)
                if(A.get(i).get(j)==0)
                    cache[i][j]=cache[i+1][j]+cache[i][j+1];
        return cache[0][0];
        
    }
}

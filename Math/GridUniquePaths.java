/*

A robot is located at the top-left corner of an A x B grid.

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

How many possible unique paths are there?

Note: A and B will be such that the resulting answer fits in a 32 bit signed integer.

Example :

Input : A = 2, B = 2
Output : 2

2 possible routes : (0, 0) -> (0, 1) -> (1, 1) 
              OR  : (0, 0) -> (1, 0) -> (1, 1)
			  
*/


public class Solution {
    int  paths(int row,int col,int atRow,int atCol,int[][] a)
    {
        if(atRow<row&&atCol<col)
        {
            if(a[atRow][atCol]>0)
                return a[atRow][atCol];
            if(atRow==row-1&&atCol==col-1)
            {
                a[atRow][atCol]=1;
                return 1;
            }
            else
            {
                int n1=paths(row,col,atRow+1,atCol,a);
                int n2=paths(row,col,atRow,atCol+1,a);
                a[atRow][atCol]=n1+n2;
                return n1+n2;
            }
        }
        return 0;
    }
    public int uniquePaths(int A, int B) {
       int[][] a=new int[A][B]; 
       return paths(A,B,0,0,a);
    }
}

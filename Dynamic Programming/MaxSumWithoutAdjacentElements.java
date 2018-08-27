/*

Given a 2 * N Grid of numbers, choose numbers such that the sum of the numbers
is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Example:

Grid:
	1 2 3 4
	2 3 4 5
so we will choose
3 and 5 so sum will be 3 + 5 = 8


Note that you can choose more than 2 numbers

*/

public class Solution {
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        int colSize=A.get(0).size();
        if(colSize<1)
        return 0;
        int[][] cache=new int[2][colSize];
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<colSize;j++)
            {
                cache[i][j]=-1;
            }
        } 
        int max=0;
        int temp=0;
        maxSum(A,0,0,cache,colSize);
        if(cache[0][0]>0)
        {
            if()
        }
        return max;
    }
    
    int maxSum(ArrayList<ArrayList<Integer>> A,int row,int col,int[][] cache,int colSize)
    {
       // System.out.println(row+" "+col);
        if(row>=2||col>=colSize)
        return 0;
        if(cache[row][col]!=-1)
        return cache[row][col];
        int k=col+2;
        int max=0;
        for(int i=0;i<2;i++)
        {
            for(int j=k;j<colSize;j++)
            {
                int temp=maxSum(A,i,j,cache,colSize);
                if(temp>max)
                max=temp;
            }
        }
        if(max+A.get(row).get(col)>0)
        max=max+A.get(row).get(col);
        cache[row][col]=max;
        return cache[row][col];
    }
}

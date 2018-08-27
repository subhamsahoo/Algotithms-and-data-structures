/*

On a N * M chessboard, where rows are numbered from 1 to N and columns from 1 to M, there are queens at some cells. Return a N * M array A, where A[i][j] is number of queens that can attack cell (i, j). While calculating answer for cell (i, j), assume there is no queen at that cell.

Notes:

Queen is able to move any number of squares vertically, horizontally or diagonally on a chessboard. A queen cannot jump over another queen to attack a position.
You are given an array of N strings, each of size M. Each character is either a 1 or 0 denoting if there is a queen at that position or not, respectively.
Expected time complexity is worst case O(N*M).
For example,

Let chessboard be,
[0 1 0]
[1 0 0]
[0 0 1]

where a 1 denotes a queen at that position.

Cell (1, 1) is attacked by queens at (2, 1), (1,2) and (3,3).
Cell (1, 2) is attacked by queen at (2, 1). Note that while calculating this, we assume that there is no queen at (1, 2).
Cell (1, 3) is attacked by queens at (3, 3) and (1, 2).
and so on...

Finally, we return matrix
[3, 1, 2]
[1, 3, 3]
[2, 3, 0]

*/

public class Solution {
    public ArrayList<ArrayList<Integer>> queenAttack(ArrayList<String> A) {
        int row=A.size(),col=A.get(0).length();
        int[][] res=new int[row][col];
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(A.get(i).charAt(j)=='1')
                {
                    //vertical up
                    int r=i-1,c=j;
                    while(r>=0)
                    {
                        res[r][c]++;
                        if(A.get(r).charAt(c)=='1')
                        break;
                        r--;
                    }
                    //vertical down
                    r=i+1;c=j;
                    while(r<row)
                    {
                        res[r][c]++;
                        if(A.get(r).charAt(c)=='1')
                        break;
                        r++;
                    }
                    
                    //horizontal front;
                    r=i;c=j-1;
                    while(c>=0)
                    {
                        res[r][c]++;
                        if(A.get(r).charAt(c)=='1')
                        break;        
                        c--;
                    }
                    
                    //horizontal back
                    r=i;c=j+1;
                    while(c<col)
                    {
                        res[r][c]++;
                        if(A.get(r).charAt(c)=='1')
                        break;
                        c++;
                    }
                    //d1
                    r=i-1;c=j-1;
                    while(r>=0&&c>=0)
                    {
                        res[r][c]++;
                        if(A.get(r).charAt(c)=='1')
                        break;  
                        r--;
                        c--;
                    }
                    //d2
                    
                    r=i+1;c=j+1;
                    while(r<row&&c<col)
                    {
                        res[r][c]++;
                        if(A.get(r).charAt(c)=='1')
                        break;
                        r++;
                        c++;
                    }
                    
                    //d3
                    r=i-1;c=j+1;
                    while(r>=0&&c<col)
                    {
                        res[r][c]++;
                        if(A.get(r).charAt(c)=='1')
                        break;
                        r--;
                        c++;
                    }
                    //d4
                    r=i+1;c=j-1;
                    while(r<row&&c>=0)
                    {
                        res[r][c]++;
                        if(A.get(r).charAt(c)=='1')
                        break;
                        r++;
                        c--;
                    }
                    
                }
            }
        }
        
         ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<row;i++)
        {
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=0;j<col;j++)
                temp.add(res[i][j]);
            result.add(temp);
        }
        
        return result;
    }
}

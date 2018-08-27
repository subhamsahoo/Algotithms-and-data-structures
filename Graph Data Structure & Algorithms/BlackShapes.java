/*

Given N * M field of O's and X's, where O=white, X=black
Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

Example:

OOOXOOO
OOXXOXO
OXOOOXO

answer is 3 shapes are  :
(i)    X
     X X
(ii)
      X
 (iii)
      X
      X
Note that we are looking for connected shapes here.

For example,

XXX
XXX
XXX
is just one single connected black shape.



*/

public class Solution {
    
    void attack(int row,int col,char[][] board)
    {
        if(row>=0&&row<board.length&&col>=0&&col<board[0].length)
        {
            if(board[row][col]=='X')
            {
                board[row][col]='O';
                attack(row+1,col,board);
                attack(row-1,col,board);
                attack(row,col+1,board);
                attack(row,col-1,board);
            }
        }
    }
    
    public int black(ArrayList<String> A) {
        int result=0;
        int row=A.size(),col=0;
        if(row>0)
        col=A.get(0).length();
        else
        return result;
        char[][] board=new char[row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                board[i][j]=A.get(i).charAt(j);
            }
        }
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(board[i][j]=='X')
                {
                    result++;
                    attack(i,j,board);
                }
            }
        }
        return result;
    }
}

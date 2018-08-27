/*

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The cell itself does not count as an adjacent cell. 
The same letter cell may be used more than once.

Example :

Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns 1,
word = "SEE", -> returns 1,
word = "ABCB", -> returns 1,
word = "ABFSAB" -> returns 1
word = "ABCD" -> returns 0
Note that 1 corresponds to true, and 0 corresponds to false.

*/

public class Solution {
    public int exist(ArrayList<String> A, String B) {
        int row=A.size(),col=0;
        if(B.length()==0)
            return 1;
        if(row>0)
            col=A.get(0).length();
        else
            return 0;
        int[][][] cache=new int[row+1][col+1][B.length()+1];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                for(int k=0;k<B.length();k++)
                    cache[i][j][k]=-1;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(A.get(i).charAt(j)==B.charAt(0))
                {
                    if(find(i,j,0,A,B,cache))
                        return 1;
                }
            }
        }
        return 0;
    }
    
        boolean find(int row,int col,int index,ArrayList<String> A,String word,int[][][] cache)
    {
        if(index==word.length())
            return true;
        if(row>=0&&row<A.size()&&col>=0&&col<A.get(0).length())
        {
            if(cache[row][col][index]!=-1)
            {
                if(cache[row][col][index]==1)
                return true;
                return false;
            }
            if(A.get(row).charAt(col)==word.charAt(index))
            {
                if(find(row+1,col,index+1,A,word,cache)){
                    cache[row][col][index]=1;
                    return true;
                }
                if(find(row-1,col,index+1,A,word,cache)){
                    cache[row][col][index]=1;
                    return true;
                }
                if(find(row,col+1,index+1,A,word,cache)){
                    cache[row][col][index]=1;
                    return true;
                }
                if(find(row,col-1,index+1,A,word,cache)){
                    cache[row][col][index]=1;
                    return true;
                }
            }
            cache[row][col][index]=0;
        }
        
        return false;
    }
}

/*

Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx

The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.

The input corresponding to the above configuration :

["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]

A partially filled sudoku which is valid.

 Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isValidSudoku(final List<String> A) {
        
        HashSet<Character> data = new HashSet<>();
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                char temp=A.get(i).charAt(j);
                if(temp!='.')
                {
                if(data.contains(temp))
                    return 0;
                data.add(temp);
                }
            }
            data.clear();
        }
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                char temp=A.get(j).charAt(i);
                if(temp!='.')
                {
                if(data.contains(temp))
                    return 0;
                data.add(temp);
                }
            }
            data.clear();
        }    
        
        int row=0,count=1,col=0;
        
        for(int i=0;i<9;i++)
        {
            if(count%3==1)
                row=(row+3)%9;
            for(int j=row;j<row+3;j++)
            {
                for(int k=col;k<col+3;k++)
                {
                    char temp=A.get(j).charAt(k);
                    if(temp!='.')
                    {
                        if(data.contains(temp))
                            return 0;
                        data.add(temp);
                    }                    
                }
            }
            data.clear();
            
            col=(col+3)%9;
            
            count++;
        }
        
        return 1;
        

    }
}

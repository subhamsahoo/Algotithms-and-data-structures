/*

Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.' 
You may assume that there will be only one unique solution.

and its solution numbers marked in red.

Example :

For the above given diagrams, the corresponding input to your program will be

[[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6], [.6....28.], [...419..5], [....8..79]]

and we would expect your program to modify the above array of array of characters to

[[534678912], [672195348], [198342567], [859761423], [426853791], [713924856], [961537284], [287419635], [345286179]]


*/


public class Solution {
    boolean columnSafe(ArrayList<ArrayList<Character>> a,int col,char num)
    {
        for(int i=0;i<9;i++)
        {
            if(a.get(i).get(col)==num)
                return false;
        }
            return true;
    }
    
    boolean rowSafe(ArrayList<ArrayList<Character>> a,int row,char num)
    {
        for(int i=0;i<9;i++)
        {
            if(a.get(row).get(i)==num)
                return false;
        }
            return true;
    }    
    
    boolean boxSafe(ArrayList<ArrayList<Character>> a,int startRow,int startCol,char num)
    {
        for(int i=startRow;i<startRow+3;i++)
        {
            for(int j=startCol;j<startCol+3;j++)
            {
                if(a.get(i).get(j)==num)
                    return false;
            }
        }
        return true;
    }
    
    boolean solving(ArrayList<ArrayList<Character>> a)
    {
        int row=-1,col=-1;
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(a.get(i).get(j)=='.')
                {
                    row=i;
                    col=j;
                    break;
                }
            }
        }
        
        
        if(row==-1&&col==-1)
            return true;
        
        for(int i=1;i<=9;i++)
        {
            if(columnSafe(a,col,(char)(i+48))&&rowSafe(a,row,(char)(i+48))&&boxSafe(a,row-(row%3),col-(col%3),(char)(i+48)))
            {
                a.get(row).set(col,(char)(i+48));
                if(solving(a))
                    return true;
                a.get(row).set(col,'.');
            }
        }
        return false;
    }

    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        solving(a);
    }
}

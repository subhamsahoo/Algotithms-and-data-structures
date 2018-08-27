/*

Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

*/


public class Solution {
    public void solve(ArrayList<ArrayList<Character>> a) {
        int row=a.size(),col=0,temp;
        if(row>0)
        {
            col=a.get(0).size();
        }
        if(col>2&&row>2)
        {
        for(int i=1;i<row-1;i++)
        {
            if(a.get(i).get(0)=='O')
            {
                attack(i,1,row,col,a);
            }
        }
        
        for(int i=1;i<row-1;i++)
        {
            if(a.get(i).get(col-1)=='O')
            {
                attack(i,col-2,row,col,a);
            }
        }
            
        for(int i=1;i<col-1;i++)
        {
            if(a.get(0).get(i)=='O')
            {
                attack(1,i,row,col,a);
            }
        }
            
        for(int i=1;i<col-1;i++)
        {
            if(a.get(row-1).get(i)=='O')
            {
                attack(row-2,i,row,col,a);
            }
        }
            
       /* for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                System.out.print(a.get(i).get(j)+" ");
            }
            System.out.println();
        }*/
            
            
        for(int i=1;i<row-1;i++)
        {
            for(int j=1;j<col-1;j++)
            {
                if(a.get(i).get(j)=='O')
                    a.get(i).set(j,'X');
                if(a.get(i).get(j)=='s')
                    a.get(i).set(j,'O');
            }
        }
        }

    }
    
    void attack(int r,int c,int row,int col,ArrayList<ArrayList<Character>> a)
    {
       // System.out.println(r+"  "+c);
        if(r>0&&r<row-1&&c>0&&c<col-1)
        {
            
            if(a.get(r).get(c)=='O')
            {
                a.get(r).set(c,'s');
                attack(r-1,c,row,col,a);
                attack(r+1,c,row,col,a);
                attack(r,c-1,row,col,a);
                attack(r,c+1,row,col,a);
            }
        }
    }
}

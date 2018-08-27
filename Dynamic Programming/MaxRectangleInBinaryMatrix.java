/*

Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

Bonus if you can solve it in O(n^2) or less.

Example :

A : [  1 1 1
       0 1 1
       1 0 0 
    ]

Output : 4 
As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)
*/

public class Solution {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        
        int row=A.size();
        if(row<1)
            return 0;
        int col=A.get(0).size();
        int [][] cache=new int[row][col];
        for(int i=0;i<col;i++)
        {
            if(A.get(0).get(i)==1)
                cache[0][i]=1;
        }
        for(int i=1;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(A.get(i).get(j)==1)
                    cache[i][j]=cache[i-1][j]+1;
            }
        }
        
        int result=0;
        
        for(int j=0;j<row;j++)
        {
        Stack<Integer> s = new Stack();
        for(int i=0;i<col;i++)
        {
            if(s.empty()||cache[j][s.peek()]<cache[j][i])
                s.push(i);
            else
            {
                while(!s.empty()&&cache[j][s.peek()]>cache[j][i])
                {
                    int h=cache[j][s.pop()];
                    int left=-1;
                    if(!s.empty())
                        left=s.peek();
                    result=Math.max(result,(i-left-1)*h);
                }

                    s.push(i);
            }
        }
        int right=col;
        while(!s.empty())
        {
            int h=cache[j][s.pop()];
            int left=-1;
            if(!s.empty())
                left=s.peek();
            result=Math.max(result,(right-left-1)*h);   
        }
        }
        
        return result;
        
    }
}

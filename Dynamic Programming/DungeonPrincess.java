/*

The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0’s) or contain magic orbs that increase the knight’s health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight’s minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path

RIGHT-> RIGHT -> DOWN -> DOWN.

Dungeon Princess: Example 1
		-2(k)	-3		3
		-5		-10		1
		10		 30		-5(P)



Input arguments to function:
Your function will get an M*N matrix (2-D array) as input which represents the 2D grid as described in the question. Your function should return an integer corresponding to the knight’s minimum initial health required. 



 Note:
The knight’s health has no upper bound.
Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

*/

public class Solution {
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
        int row=A.size(),col=A.get(0).size();
        int[][] cache=new int[row][col];
        if(A.get(row-1).get(col-1)>=0)
            cache[row-1][col-1]=0;
        else
            cache[row-1][col-1]=A.get(row-1).get(col-1);
        
        for(int i=col-2;i>=0;i--)
        {
            if(A.get(row-1).get(i)+cache[row-1][i+1]>=0)
                cache[row-1][i]=0;
            else
                cache[row-1][i]=A.get(row-1).get(i)+cache[row-1][i+1];
        }
        for(int i=row-2;i>=0;i--)
        {
            if(A.get(i).get(col-1)+cache[i+1][col-1]>=0)
                cache[i][col-1]=0;
            else
                cache[i][col-1]=A.get(i).get(col-1)+cache[i+1][col-1];            
        }
        
        for(int i=row-2;i>=0;i--)
        {
            for(int j=col-2;j>=0;j--)
            {
                if(cache[i+1][j]==0||cache[i][j+1]==0)
                {
                    if(A.get(i).get(j)>=0)
                    cache[i][j]=0;
                 else
                     cache[i][j]=A.get(i).get(j);
                }
                else{
                    int temp=A.get(i).get(j)+Math.max(cache[i+1][j],cache[i][j+1]);
                    if(temp>=0)
                        cache[i][j]=0;
                    else
                        cache[i][j]=temp;
                }
            }
        }
            if(cache[0][0]<0)
            return Math.abs(cache[0][0])+1;
            return 1;
        
    }
}



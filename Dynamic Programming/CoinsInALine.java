/*

There are N coins (Assume N is even) in a line. Two players take turns to take a coin from one of the ends of the line until there are no more coins left. The player with the larger amount of money wins. Assume that you go first.

Write a program which computes the maximum amount of money you can win.

Example:

suppose that there are 4 coins which have value
1 2 3 4
now you are first so you pick 4
then in next term
next person picks 3 then
you pick 2 and
then next person picks 1
so total of your money is 4 + 2 = 6
next/opposite person will get 1 + 3 = 4
so maximum amount of value you can get is 6

*/

public class Solution {
    public int maxcoin(ArrayList<Integer> A) {
        int[][] cache1=new int[A.size()][A.size()];
        int[][] cache2=new int[A.size()][A.size()];
        for(int i=0;i<A.size();i++)
        {
            for(int j=0;j<A.size();j++)
            {
                cache1[i][j]=Integer.MAX_VALUE;
                cache2[i][j]=Integer.MAX_VALUE;
            }
        }
        return turn1(A,0,A.size()-1,cache1,cache2);
    }
    int turn1(ArrayList<Integer> A,int start,int end,int[][] cache1,int[][] cache2)
    {
        if(cache1[start][end]!=Integer.MAX_VALUE)
        return cache1[start][end];
        int m1=A.get(start)+turn2(A,start+1,end,cache1,cache2);
        int m2=A.get(end)+turn2(A,start,end-1,cache1,cache2);
        cache1[start][end]=Math.max(m1,m2);
        return cache1[start][end];
    }

    int turn2(ArrayList<Integer> A,int start,int end,int[][] cache1,int[][] cache2)
    {
        if(start==end)
        return 0;
        if(cache2[start][end]!=Integer.MAX_VALUE)
        return cache2[start][end];       
        int m1=turn1(A,start+1,end,cache1,cache2);
        int m2=turn1(A,start,end-1,cache1,cache2);
        cache2[start][end]=Math.min(m1,m2);
        return cache2[start][end];
    }    
}


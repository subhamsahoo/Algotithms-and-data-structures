/*

Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example : 
edit distance between
"Anshuman" and "Antihuman" is 2.

Operation 1: Replace s with t.
Operation 2: Insert i.

*/

public class Solution {
    public int minDistance(String A, String B) {
        int cache[][]=new int[A.length()+1][B.length()+1];
        cache[A.length()][B.length()]=0;
        for(int i=0;i<A.length();i++)
            cache[i][B.length()]=A.length()-i;
        for(int i=0;i<B.length();i++)
            cache[A.length()][i]=B.length()-i;
        for(int i=A.length()-1;i>=0;i--)
        {
            for(int j=B.length()-1;j>=0;j--)
            {
                if(A.charAt(i)==B.charAt(j))
                    cache[i][j]=cache[i+1][j+1];
                else
                {
                    cache[i][j]=1+cache[i+1][j];
                    if(cache[i][j+1]+1<cache[i][j])
                        cache[i][j]=cache[i][j+1]+1;
                    if(cache[i+1][j+1]+1<cache[i][j])
                        cache[i][j]=cache[i+1][j+1]+1;
                    
                }
            }
        }
        return cache[0][0];
    }
}

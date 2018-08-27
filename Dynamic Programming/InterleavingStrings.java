/*

Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example,
Given:

s1 = "aabcc",
s2 = "dbbca",
When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem



*/

public class Solution {
        int find(String s1,String s2,String s3,int start1,int start2,int start3,int[][] cache)
    {
        if(start3==s3.length()&&start2==s2.length()&&start1==s1.length())
            return 1;
        if(start3==s3.length())
            return 0;
        if(cache[start1][start2]!=-1)
            return cache[start1][start2];
        if(start1<s1.length()&&start2<s2.length()&&s1.charAt(start1)==s2.charAt(start2))
        {
            if(s1.charAt(start1)==s3.charAt(start3))
                cache[start1][start2]=find(s1,s2,s3,start1+1,start2,start3+1,cache)|find(s1,s2,s3,start1,start2+1,start3+1,cache);
            else
                cache[start1][start2]=0;
            return cache[start1][start2];
        }
        if(start1<s1.length()&&s1.charAt(start1)==s3.charAt(start3))
        {
            cache[start1][start2]=find(s1,s2,s3,start1+1,start2,start3+1,cache);
            return cache[start1][start2];
        }
        if(start2<s2.length()&&s2.charAt(start2)==s3.charAt(start3))
        {
            cache[start1][start2]=find(s1,s2,s3,start1,start2+1,start3+1,cache);
            return cache[start1][start2];
        }
        cache[start1][start2]=0;
        return cache[start1][start2];
    }
    public int isInterleave(String A, String B, String C) {
        
        int cache[][]=new int[A.length()+1][B.length()+1];
        for(int i=0;i<=A.length();i++)
            for(int j=0;j<=B.length();j++)
                cache[i][j]=-1;
        return find(A,B,C,0,0,0,cache);
    }
}

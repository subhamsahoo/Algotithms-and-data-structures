/*

Find out the number of N digit numbers, whose digits on being added equals to a given number S. Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.

Since the answer can be large, output answer modulo 1000000007

**

N = 2, S = 4 
Valid numbers are {22, 31, 13, 40} 
Hence output 4.

*/

public class Solution {
    public int solve(int A, int B) {
        if(B>(A*9)&&B<1)
        return 0;
        if(B==(A*9)||B==1)
        return 1;
        int[][] cache=new int[A][B+1];
        int temp=Math.min(B,9);
        for(int i=0;i<=temp;i++)
        cache[0][i]=1;
        for(int i=1;i<A;i++)
        {
            
            for(int j=0;j<=B;j++)
            {
                long result=0;
                int sum=j;
                int k=0;
                if(i==A-1)
                k=1;
                while(k<=9)
                {
                    if(sum-k>=0)
                    result=(result+cache[i-1][sum-k])%1000000007;
                    else
                    break;
                    k++;
                }
               cache[i][j]=(int)result; 
            }
        }
        return cache[A-1][B]%1000000007;
    }
}

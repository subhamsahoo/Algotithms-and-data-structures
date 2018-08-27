/*

Given A, how many structurally unique BST’s (binary search trees) that store values 1...A?

Example :

Given A = 3, there are a total of 5 unique BST’s.


   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
 */
 
 
 public class Solution {
    public int numTrees(int A) {
        int[] cache=new int[A+1];
        cache[0]=1;
        for(int i=1;i<=A;i++)
        {
            int result=0;
            for(int j=1;j<=i;j++)
            {
                int temp=cache[Math.abs(1-j)]*cache[i-j];
                result=result+temp;
            }
            cache[i]=result;
        }
        return cache[A];
    }
}

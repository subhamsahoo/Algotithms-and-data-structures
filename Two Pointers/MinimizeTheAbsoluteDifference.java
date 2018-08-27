/*

Given three sorted arrays A, B and Cof not necessarily same sizes.

Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
i.e. minimize | max(a,b,c) - min(a,b,c) |.

Example :

Input:

A : [ 1, 4, 5, 8, 10 ]
B : [ 6, 9, 15 ]
C : [ 2, 3, 6, 6 ]
Output:

1
Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.

*/

public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int length1=A.size(),length2=B.size(),length3=C.size();
        int i=0,j=0,k=0;
        int result=Integer.MAX_VALUE;
        while(i<length1||j<length2||k<length3)
        {
            int max=A.get(i),min=A.get(i);
            int minIndex=1;
            if(B.get(j)>max)
            max=B.get(j);
            if(C.get(k)>max)
            max=C.get(k);
            if(B.get(j)<min)
            {
                min=B.get(j);
                minIndex=2;
            }
            if(C.get(k)<min)
            {
                min=C.get(k);
                minIndex=3;
            }
            
            if(Math.abs(max-min)<result)
            result=Math.abs(max-min);
            if(minIndex==1)
            i++;
            if(minIndex==2)
            j++;
            if(minIndex==3)
            k++;
            if(i==length1||j==length2||k==length3)
            break;
        }
        return result;
    }
}

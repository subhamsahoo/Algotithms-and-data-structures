/*

Find longest Arithmetic Progression in an integer array and return its length. More formally, find longest sequence of indeces, 0 < i1 < i2 < … < ik < ArraySize(0-indexed) such that sequence A[i1], A[i2], …, A[ik] is an Arithmetic Progression. Arithmetic Progression is a sequence in which all the differences between consecutive pairs are the same, i.e sequence B[0], B[1], B[2], …, B[m - 1] of length m is an Arithmetic Progression if and only if B[1] - B[0] == B[2] - B[1] == B[3] - B[2] == … == B[m - 1] - B[m - 2].
Examples
1) 1, 2, 3(All differences are equal to 1)
2) 7, 7, 7(All differences are equal to 0)
3) 8, 5, 2(Yes, difference can be negative too)

Samples
1) Input: 3, 6, 9, 12
Output: 4

2) Input: 9, 4, 7, 2, 10
Output: 3(If we choose elements in positions 1, 2 and 4(0-indexed))

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A) {
        int max=0,length=A.size();
        if(length<3)
        return length;
        for(int i=0;i<length-2;i++)
        {
            for(int j=i+1;j<length-1;j++)
            {
                int temp=maxAP(j,A.get(j)-A.get(i),A);
                if(temp>max)
                max=temp;
                if(max==length)
                return max;
            }
        }
        return max;
        
    }
    
    int maxAP(int last,int diff,final List<Integer> A)
    {
        int temp=last;
        int count=0;
        for(int i=last+1;i<A.size();i++)
        {
            if(A.get(i)-A.get(temp)==diff)
            {
                temp=i;
                count++;
            }
        }
        return  count+2;
    }
}

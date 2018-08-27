/*

You are given with an array of 1s and 0s. And you are given with an integer M, which signifies number of flips allowed.
Find the position of zeros which when flipped will produce maximum continuous series of 1s.

For this problem, return the indices of maximum continuous series of 1s in order.

Example:

Input : 
Array = {1 1 0 1 1 0 0 1 1 1 } 
M = 1

Output : 
[0, 1, 2, 3, 4] 

If there are multiple possible solutions, return the sequence which has the minimum start index.

*/

public class Solution {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        int start=0;
        int maxStart=0,maxEnd=0;
        int nextZero=-1;
        int length=A.size();
        for(int i=0;i<length;i++)
        {
            if(A.get(i)==0)
            {
                if(nextZero==-1)
                    nextZero=i;
                if(B>0)
                B--;
                else
                {
                    if((i-1-start)>maxEnd-maxStart)
                    {
                        maxStart=start;
                        maxEnd=i-1;
                    }
                    start=nextZero+1;
                    int temp=start;
                    while(temp<length&&A.get(temp)!=0)
                    temp++;
                    nextZero=temp;
                }
            }
        }
        if(start<length)
        {
            if((length-1-start)>maxEnd-maxStart)
            {
                    maxStart=start;
                    maxEnd=length-1;                
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=maxStart;i<=maxEnd;i++)
        result.add(i);
        return result;
    }
}

/*

Given a set of digits (A) in sorted order, find how many numbers of length B are possible whose value is less than number C.

 NOTE: All numbers can only have digits from the given set. 
Examples:

	Input:
	  0 1 5  
	  1  
	  2  
	Output:  
	  2 (0 and 1 are possible)  

	Input:
	  0 1 2 5  
	  2  
	  21  
	Output:
	  5 (10, 11, 12, 15, 20 are possible)
Constraints:

    1 <= B <= 9, 0 <= C <= 1e9 & 0 <= A[i] <= 9
	
*/


public class Solution {
    public int solve(ArrayList<Integer> A, int B, int C) {
        if(A.size()==0)
        return 0;
        ArrayList<Integer> data = new ArrayList<>();
        while(C>0)
        {
            data.add(C%10);
            C=C/10;
        }
        Collections.reverse(data);
        if(B<data.size()||(A.get(A.size()-1)<data.get(0)&&B==data.size()))
        {
            int length=A.size();
            int result=length;
            if(A.get(0)==0&&B>1)
            result=length-1;
            for(int i=2;i<=B;i++)
            result=result*length;
            return result;
        }
        if(B>data.size())
        return 0;
        
        int result=0;
        int start=0;
        int length=A.size();
        while(start<B)
        {
            int count=0,i;
            for(i=0;i<length;i++)
            {
                if(A.get(i)<data.get(start))
                count++;
                else
                break;
            }
            if(start==0&&A.get(0)==0&&B>1)
            count=count-1;
            if(count!=0)
                for(int j=start+1;j<B;j++)
                    count=count*length;
            result=result+count;
            if(i==length||A.get(i)>data.get(start))
            break;
            start++;
        }
        return result;
    }
}

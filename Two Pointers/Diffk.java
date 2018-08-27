/*

Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

 Example: Input : 
    A : [1 3 5] 
    k : 4
 Output : YES as 5 - 1 = 4 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Try doing this in less than linear space complexity.

*/

public class Solution {
    public int diffPossible(ArrayList<Integer> A, int B) {
        int length=A.size();
        int i=0,j=1;
        while(i<length&&j<length)
        {
            if(i==j)
            j++;
            if(j==length)
            return 0;
            if((A.get(j)-A.get(i))==B)
            return 1;
            if((A.get(j)-A.get(i))<B)
            j++;
            else
            i++;
        }
        return 0;
    }
}

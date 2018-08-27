/*

Noble Integer
Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
If such an integer is found return 1 else return -1.

*/

public class Solution {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int size=A.size(),i=0;
        while(i<size-1)
        {
            if(A.get(i)==A.get(i+1))
            i++;
            else
            {
                int length=size-i-1;
                if(length==A.get(i))
                return 1;
                i++;
            }
        }
        if(A.get(size-1)==0)
        return 1;
        return -1;
    }
}

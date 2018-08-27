/*

Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2. 

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int majorityElement(final List<Integer> A) {
        int number=A.get(0),count=1,length=A.size();
        for(int i=1;i<length;i++)
        {
            if(A.get(i)==number)
                count++;
            else
            {
                if(count>0)
                    count--;
                else
                {
                    number=A.get(i);
                    count=1;
                }
            }
        }
        return number;
    }
}

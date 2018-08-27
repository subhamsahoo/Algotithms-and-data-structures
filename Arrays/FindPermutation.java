/*

Given a positive integer n and a string s consisting only of letters D or I, you have to find any permutation of first n positive integer that satisfy the given input string.

D means the next number is smaller, while I means the next number is greater.

Notes

Length of given string s will always equal to n - 1
Your solution should run in linear time and space.
Example :

Input 1:

n = 3

s = ID

Return: [1, 3, 2]


*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findPerm(final String A, int B) {
        int i=1,d=B;
        ArrayList<Integer> result=new ArrayList<>();
        for(int j=0;j<A.length();j++)
        {
            if(A.charAt(j)=='I')
            {
                result.add(i);
                i=i+1;
            }
            else
            {
                result.add(d);
                d=d-1;
            }
        }
        if(A.charAt(B-2)=='D')
        result.add(i);
        else result.add(d);
        return result;
    }
}

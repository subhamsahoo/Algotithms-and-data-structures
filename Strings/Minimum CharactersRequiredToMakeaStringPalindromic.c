/*

You are given a string. The only operation allowed is to insert characters in the beginning of the string. How many minimum characters are needed to be inserted to make the string a palindrome string

Example:
Input: ABC
Output: 2
Input: AACECAAAA
Output: 2

*/

int Solution::solve(string A) {
    int length=A.length();
    int i=0,j=length-1,start=length-1;
    while(i<j)
    {
        if(A[i]==A[j])
        {
            i++;
            j--;
        }
        else
        {
            if(i==0)
            j--;
            i=0;
            start=j;
        }
    }
    return A.length()-1-start;
    
}

/*

Implement strStr().

 strstr - locate a substring ( needle ) in a string ( haystack ). 
Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 NOTE: Good clarification questions:
What should be the return value if the needle is empty?
What if both haystack and needle are empty?
For the purpose of this problem, assume that the return value should be -1 in both cases. 

*/

int Solution::strStr(const string A, const string B) {
    int length1=A.length(),length2=B.length();
    if(length1==0||length2==0||length2>length1)
    return -1;
    for(int i=0;i<=length1-length2;i++)
    {
        int temp=i,j=0;
        while(j<length2&&A[temp]==B[j])
        {
            temp++;
            j++;
        }
        if(j==length2)
        return i;
    }
    return -1;
}

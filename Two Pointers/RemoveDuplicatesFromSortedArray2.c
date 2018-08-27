/*

Remove Duplicates from Sorted Array

Given a sorted array, remove the duplicates in place such that each element can appear atmost twice and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Note that even though we want you to return the new length, make sure to change the original array as well in place

For example,
Given input array A = [1,1,1,2],

Your function should return length = 3, and A is now [1,1,2].

*/


/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer
 */
int removeDuplicates(int* A, int n1) {
        int j,i;
    for(i=0;i<n1;i=j)
    {
        j=i+1;
        if(A[i]==A[j]&&j<n1)
        {
            j++;
        }
        while(A[i]==A[j]&&j<n1)
        {
            A[j]=INT_MIN;
            j++;
        }
    }
    j=0;
    for(i=0;i<n1;i++)
    {
        if(A[i]!=INT_MIN)
            A[j++]=A[i];
    }
    return j;
}

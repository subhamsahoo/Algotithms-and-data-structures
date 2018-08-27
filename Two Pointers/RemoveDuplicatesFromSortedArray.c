/*

Remove duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

Note that even though we want you to return the new length, make sure to change the original array as well in place

Do not allocate extra space for another array, you must do this in place with constant memory.

 Example: 
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2]. 

*/

/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer
 */
int removeDuplicates(int* A, int n1) {
    int i=0,j=1;
    while(j<n1)
    {
        if(A[i]==A[j])
        {
            A[j]=INT_MIN;
            j++;
        }
        else
        {
            i=j;j++;
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

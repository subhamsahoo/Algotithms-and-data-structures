/*

You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
If A is already sorted, output -1.

Example :

Input 1:

A = [1, 3, 2, 4, 5]

Return: [1, 2]

Input 2:

A = [1, 2, 3, 4, 5]

Return: [-1]
In the above example(Input 1), if we sort the subarray A1, A2, then whole array A should get sorted.

*/

/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer array. You need to malloc memory, and fill the length in len1
 */
int* subUnsort(int* A, int n1, int *len1) {
    int left=-1,right=-1,i;
    for(i=0;i<n1-1;i++)
    {
        if(A[i]>A[i+1])
        {
            left=i+1;
            break;
        }
    }
    for(i=n1-1;i>0;i--)
    {
        if(A[i]<A[i-1])
        {
            right=i-1;
            break;
        }
    }
    if(left==-1&&right==-1)
    {
    int *result = (int*)malloc(sizeof(int)*1);
    result[0]=-1;
    *len1=1;
    return result;
    }
    int min=A[left],max=A[left];
    int *result = (int*)calloc(sizeof(int),2);
    *len1=2;
    if(left>right)
    {
      int temp=left;
      left=right;
      right=temp;
    }
    for(i=left;i<=right;i++)
    {
        if(A[i]>max)
        max=A[i];
        else if(A[i]<min)
        min=A[i];
    }
    for(i=left-1;i>=0;i--)
    {
        if(A[i]>max)
        max=A[i];
    }
    for(i=right+1;i<n1;i++)
    {
        if(A[i]<min)
        min=A[i];
    }
    for(i=left-1;i>=0;i--)
    {
        if(A[i]<=min)
        {
            result[0]=i+1;
            break;
        }
    }
    for(i=right+1;i<n1;i++)
    {
        if(A[i]>=max)
        {
            result[1]=i-1;
            break;
        }
    }
    if(result[1]==0)
        result[1]=n1-1;
    return result;
}

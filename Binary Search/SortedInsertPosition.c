/*

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.

[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

*/

/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * @input B : Integer
 * 
 * @Output Integer
 */
int searchInsert(int* A, int n1, int B) {
    if(A[n1-1]<B)
    return n1;
    if(A[0]>B)
    return 0;
    int low=0,high=n1-1;
    while(low<=high)
    {
        int mid=low+(high-low)/2;
        if(A[mid]==B)
        return mid;
        else if(mid-1>-1&&A[mid-1]<B&&A[mid]>B)
        return mid;
        else if(mid+1<n1&&A[mid]<B&&A[mid+1]>B)
        return mid+1;
        else if(A[mid]>B)
        high=mid-1;
        else low=mid+1;
    }
}

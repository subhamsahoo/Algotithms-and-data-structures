/*

Suppose a sorted array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array will not contain duplicates.

NOTE 1: Also think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*

*/

/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer
 */
 
 int search(int* A,int n1)
 {
     int low=0,high=n1-1,decision=A[n1-1];
     while(low<=high)
     {
         int mid=low+(high-low)/2;
         if(mid-1>=0&&mid+1<n1&&A[mid-1]>A[mid]&&A[mid+1]>A[mid])
         return A[mid];
         else if(A[mid]>decision)
         low=mid+1;
         else
         high=mid-1;
     }
     return -1;
     
 }
 
int findMin(const int* A, int n1) {
    if(n1==1)
    return A[0];
    if(A[0]<=A[n1-1])
    return A[0];
    return search(A,n1);
}

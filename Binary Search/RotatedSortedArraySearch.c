/*

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

You are given a target value to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Input : [4 5 6 7 0 1 2] and target = 4
Output : 0

*/

/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * @input B : Integer
 * 
 * @Output Integer
 */
 
 int helper(const int *A,int n1,int B)
 {
     int low=0,high=n1-1,decision=A[n1-1];
     while(low<=high)
     {
         int mid=low+(high-low)/2;
         if(A[mid]==B)
         return mid;
         else if(A[mid]>decision)
         {
             if(B<=decision)
             low=mid+1;
             else if(B>decision&&A[mid]<B)
             low=mid+1;
             else if(B>decision&&A[mid]>B)
             high=mid-1;
         }
         else
         {
             if(B>decision)
             high=mid-1;
             else if(B<=decision&&A[mid]<B)
             low=mid+1;
             else if(B<=decision&&A[mid]>B)
             high=mid-1;
         }
     }
     return -1;
 }
 
 int binarySearch(int* A,int n1,int B)
 {
     int low=0,high=n1-1;
     while(low<=high)
     {
         int mid=low+(high-low)/2;
         if(A[mid]==B)
         return mid;
         else if(A[mid]>B)
         high=mid-1;
         else low=mid+1;
     }
     return -1;
 }
 
int search(const int* A, int n1, int B) {
    if(n1>1)
    {
        if(A[0]<A[n1-1])
        return binarySearch(A,n1,B);
    }
    return helper(A,n1,B);
}

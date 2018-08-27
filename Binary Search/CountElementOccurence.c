/*

Given a sorted array of integers, find the number of occurrences of a given target value.
Your algorithm’s runtime complexity must be in the order of O(log n).
If the target is not found in the array, return 0

**Example : **
Given [5, 7, 7, 8, 8, 10] and target value 8,
return 2.

*/

/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * @input B : Integer
 * 
 * @Output Integer
 */
 
 int search(const int* A,int n1,int B,int left)
 {
     int low=0,high=n1-1,mid,result=-1;
     while(low<=high)
     {
         mid=low+(high-low)/2;
         if(A[mid]==B)
         {
             result=mid;
             if(left==1)
             high=mid-1;
             else
             low=mid+1;
         }
         else if(A[mid]>B)
         high=mid-1;
         else
         low=mid+1;
     }
     return result;
 }
 
int findCount(const int* A, int n1, int B) {
    
    int leftIndex=search(A,n1,B,1);
    if(leftIndex==-1)
    return 0;
    int rightIndex = search(A,n1,B,0);
    return rightIndex-leftIndex+1;
}

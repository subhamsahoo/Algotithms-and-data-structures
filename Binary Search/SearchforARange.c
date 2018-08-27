/*

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm’s runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example:

Given [5, 7, 7, 8, 8, 10]

and target value 8,

return [3, 4].

*/

/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * @input B : Integer
 * 
 * @Output Integer array. You need to malloc memory, and fill the length in len1
 */
 
 
 int search(const int* A,int n1,int B,int direction)
 {
     int low=0,high=n1-1,result=-1;
     while(low<=high)
     {
         int mid=low+(high-low)/2;
         if(A[mid]==B)
         {
             result=mid;
             if(direction==1)
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
 
int* searchRange(const int* A, int n1, int B, int *len1) {
    *len1=2;
    int *result=(int*)malloc(sizeof(int)*(*len1));
    result[0]=search(A,n1,B,1);
    if(result[0]==-1)
    {
        result[1]=-1;
        return result;
    }
    result[1]=search(A,n1,B,0);
    return result;
}

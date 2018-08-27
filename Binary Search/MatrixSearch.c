/*

Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Example:

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return 1 ( 1 corresponds to true )

Return 0 / 1 ( 0 if the element is not present, 1 if the element is present ) for this problem

*/

/**
 * @input A : 2D integer array ' * @input n11 : Integer array's ( A ) rows
 * @input n12 : Integer array's ( A ) columns
 * @input B : Integer
 * 
 * @Output Integer
 */
 
 int binarySearch(int** A,int row,int col,int B)
 {
     int low=0,high=col-1;
     while(low<=high)
     {
         int mid=low+(high-low)/2;
         if(A[row][mid]==B)
         return 1;
         else if(A[row][mid]>B)
         high=mid-1;
         else
         low=mid+1;
     }
     return 0;
 }
 
int searchMatrix(int** A, int n11, int n12, int B) {
    int i;
    for(i=0;i<n11;i++)
    {
        if(A[i][0]==B||A[i][n12-1]==B)
        return 1;
        if(A[i][0]<B&&A[i][n12-1]>B)
        return binarySearch(A,i,n12,B);
    }
    return 0;
}

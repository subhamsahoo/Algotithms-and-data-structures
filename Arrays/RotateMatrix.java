/*


You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is

[
    [1, 2],
    [3, 4]
]
Then the rotated array becomes:

[
    [3, 1],
    [4, 2]
]


*/

/**
 * @input A : 2D integer array 
 * @input n11 : Integer array's ( A ) rows
 * @input n12 : Integer array's ( A ) columns
 * 
 * @Output Void. Just modifies the args passed by reference 
 */
void rotate(int** A, int n11, int n12) {
    int i,j,k;
    for(i=0;i<n11;i++)
    {
        for(j=0;j<n12;j++)
        {
            if(i<j)
            {
                int temp=A[i][j];
                A[i][j]=A[j][i];
                A[j][i]=temp;
            }
        }
    }
    i=0;j=n11-1;
    while(i<j)
    {
        for(k=0;k<n11;k++)
        {
            int temp=A[k][i];
            A[k][i]=A[k][j];
            A[k][j]=temp;
        }
        i++;
        j--;
    }
}

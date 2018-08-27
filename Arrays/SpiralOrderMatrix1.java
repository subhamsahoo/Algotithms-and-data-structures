/*


Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example:

Given the following matrix:

[
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
]
You should return

[1, 2, 3, 6, 9, 8, 7, 4, 5]


*/

/**
 * @input A : Read only ( DON'T MODIFY ) 2D integer array 
 * @input n11 : Integer array's ( A ) rows
 * @input n12 : Integer array's ( A ) columns
 * 
 * @Output Integer array. You need to malloc memory, and fill the length in len1
 */
int* spiralOrder(const int** A, int n11, int n12, int *len1) {
    int rs=0,re=n11-1,cs=0,ce=n12-1,dir=1,i=0,j;
    *len1=n11*n12;
    int *result = (int*)malloc(sizeof(int)*(*len1));
    while(rs<=re&&cs<=ce)
    {
        if(dir==1)
        {
            for(j=cs;j<=ce;j++)
            {
                result[i++]=A[rs][j];
            }
            rs++;
            dir=2;
        }
        else if(dir==2)
        {
            for(j=rs;j<=re;j++)
            {
                result[i++]=A[j][ce];
            }
            ce--;
            dir=3;
        }
        else if(dir==3)
        {
            for(j=ce;j>=cs;j--)
            {
                result[i++]=A[re][j];
            }
            re--;
            dir=4;
        }
        else if(dir==4)
        {
            for(j=re;j>=rs;j--)
            {
                result[i++]=A[j][cs];
            }
            cs++;
            dir=1;
        }
    }
    return result;
}

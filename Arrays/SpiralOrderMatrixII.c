/*


Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Given n = 3,

You should return the following matrix:

[
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
]

*/



/**
 * @input A : Integer
 * 
 * @Output 2D int array. You need to malloc memory. Fill in len1 as row, len2 as columns 
 */
int ** generateMatrix(int A, int *len1, int *len2) {
    int rs=0,re=A-1,cs=0,ce=A-1,i,dir=1,count=1,j;
    *len1=*len2=A;
    int **result=(int**)malloc(sizeof(int*)*A);
    for(i=0;i<A;i++)
        result[i]=(int*)malloc(sizeof(int)*A);
    while(rs<=re&&cs<=ce)
    {
        if(dir==1)
        {
            for(j=cs;j<=ce;j++)
            {
                result[rs][j]=count++;
            }
            rs++;
            dir=2;
        }
        else if(dir==2)
        {
            for(j=rs;j<=re;j++)
            {
                result[j][ce]=count++;
            }
            ce--;
            dir=3;
        }
        else if(dir==3)
        {
            for(j=ce;j>=cs;j--)
            {
                result[re][j]=count++;
            }
            re--;
            dir=4;
        }
        else if(dir==4)
        {
            for(j=re;j>=rs;j--)
            {
                result[j][cs]=count++;
            }
            cs++;
            dir=1;
        }
    }
    return result;
}

/*

Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:

A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]
NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
NOTE 2: If there is still a tie, then return the segment with minimum starting index

*/



/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer array. You need to malloc memory, and fill the length in len1
 */
int* maxset(int* A, int n1, int *len1) {
    long long gstart=-1,gend=-1,gmax=-1;
     long long start=-1,end=-1,sum=0,i;
     for(i=0;i<n1;i++)
    {
        if(A[i]>=0)
        {
            sum=sum+A[i];
            if(start==-1)
            start=i;
        }
        else
        {
            if(start==-1&&end==-1){}
            else
            {
                end=i-1;
                if(sum>gmax)
                {
                    gmax=sum;
                    gstart=start;
                    gend=end;
                }
                if(sum==gmax)
                {
                    if((end-start)>(gend-gstart))
                    {
                        gstart=start;
                        gend=end;
                    }
                }
                
                    sum=0;
                    start=-1;
                    end=-1;
            }
        }
    }
    if(sum>gmax)
    {
                    gstart=start;
                    gend=n1-1;
    }
     if(sum==gmax)
                {
                    if((end-start)>(gend-gstart))
                    {
                        gstart=start;
                        gend=n1-1;
                    }
                }
    if(gstart==-1){
        *len1=0;
    return NULL;
    }
    *len1=gend-gstart+1;
    int *result = (int*)malloc(sizeof(int)*(*len1)),count=0;
    for(i=gstart;i<=gend;i++)
    result[count++]=A[i];
    return result;
    
}

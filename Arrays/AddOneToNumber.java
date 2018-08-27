/*

Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.

*/

/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer array. You need to malloc memory, and fill the length in len1
 */
int* plusOne(int* A, int n1, int *len1) {
    
    *len1=n1+1;
    int *result=(int*)calloc(sizeof(int),(*len1));
    int carry=1,rpointer=n1,i=n1-1;
    for(;i>=0;i--)
    {
        result[rpointer--]=(A[i]+carry)%10;
        carry=(A[i]+carry)/10;
    }
    result[rpointer]=carry;
    int count=0;
    for(i=0;i<(*len1)&&result[i]==0;i++)
    count++;
    result=result+count;
    (*len1)=(*len1)-count;
    return result;
}

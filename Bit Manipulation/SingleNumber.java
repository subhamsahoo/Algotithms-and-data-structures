/*


Given an array of integers, every element appears twice except for one. Find that single one.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example :

Input : [1 2 2 3 1]
Output : 3

*/

/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer
 */
int singleNumber(const int* A, int n1) {
    if(n1==0)
    return 0;
    int i,result=A[0];
    for(i=1;i<n1;i++)
    {
        result=result^A[i];
    }
    return result;
}

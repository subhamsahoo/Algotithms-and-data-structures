/*

Given two sorted integer arrays A and B, merge B into A as one sorted array.

 Note: You have to modify the array A to contain the merge of A and B. Do not output anything in your code.
TIP: C users, please malloc the result into a new array and return the result. 
If the number of elements initialized in A and B are m and n respectively, the resulting size of array A after your code is executed should be m + n

Example :

Input : 
         A : [1 5 8]
         B : [6 9]

Modified A : [1 5 6 8 9]

*/

/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * @input B : Integer array
 * @input n2 : Integer array's ( B ) length
 * 
 * @Return Returns a array of size n1 + n2 with A and B merged. 
 */
int* merge(int* A, int n1, int* B, int n2) {
    int *result=(int*)malloc(sizeof(int)*(n1+n2));
    int i=0,j=0,k=0;
    while(i<n1&&j<n2)
    {
        if(A[i]<B[j])
        {
            result[k++]=A[i];
            i++;
        }
        else
        {
            result[k++]=B[j];
            j++;
        }
    }
    while(i<n1)
    {
            result[k++]=A[i];
            i++;
    }
    while(j<n2)
    {
        result[k++]=B[j];
        j++;
    }
    return result;
}

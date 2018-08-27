/*

Find the intersection of two sorted arrays.
OR in other words,
Given 2 sorted arrays, find all the elements which occur in both the arrays.

Example :

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 3 5]

Output : [3 3 5]

Input : 
    A : [1 2 3 3 4 5 6]
    B : [3 5]

Output : [3 5]


*/

/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * @input B : Read only ( DON'T MODIFY ) Integer array
 * @input n2 : Integer array's ( B ) length
 * 
 * @Output Integer array. You need to malloc memory, and fill the length in len1
 */
int* intersect(const int* A, int n1, const int* B, int n2, int *len1) {
    int min=n1<n2?n1:n2;
    int *result=(int*)malloc(sizeof(int)*min);
    int i=0,j=0,count=0;
    while(i<n1&&j<n2)
    {
        if(A[i]==B[j])
        {
            result[count++]=A[i];
            i++;
            j++;
        }
        else if(A[i]<B[j])
        i++;
        else
        j++;
    }
    *len1=count;
    return result;
}

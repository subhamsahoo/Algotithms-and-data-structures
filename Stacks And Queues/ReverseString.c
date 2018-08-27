/*

Given a string S, reverse the string using stack.

Example :

Input : "abc"
Return "cba"

*/

/**
 * @input A : String termination by '\0'
 * 
 * @Output string. Make sure the string ends with null character
 */
char* reverseString(char* A) {
    int i,j;
    for(i=0;A[i]!='\0';i++);
    j=i-1;
    i=0;
    while(i<j)
    {
        char temp=A[i];
        A[i]=A[j];
        A[j]=temp;
        i++;
        j--;
    }
    return A;
}

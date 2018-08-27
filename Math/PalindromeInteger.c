/*


Determine whether an integer is a palindrome. Do this without extra space.

A palindrome integer is an integer x for which reverse(x) = x where reverse(x) is x with its digit reversed.
Negative numbers are not palindromic.

Example :

Input : 12121
Output : True

Input : 123
Output : False

*/

/**
 * @input A : Integer
 * 
 * @Output Integer
 */
int isPalindrome(int A) {
    int temp=A,rev=0;
    while(A>0)
    {
        rev=rev*10+(A%10);
        A=A/10;
    }
    if(rev==temp)
    return 1;
    return 0;
}

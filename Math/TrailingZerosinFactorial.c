/*

Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.

Example :

n = 5
n! = 120 
Number of trailing zeros = 1
So, return 1

*/

/**
 * @input A : Integer
 * 
 * @Output Integer
 */
int trailingZeroes(int A) {
     int result=0,div=5,ans;
    do{
        ans=A/div;
        result=result+ans;
        div=div*5;
    }while(ans>0);
    return result;
}

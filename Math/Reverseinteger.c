/*

Reverse digits of an integer.

Example1:

x = 123,

return 321
Example2:

x = -123,

return -321

Return 0 if the result overflows and does not fit in a 32 bit signed integer

*/

/**
 * @input A : Integer
 * 
 * @Output Integer
 */
int reverse(int A) {
    long long rev=0;
    int neg=1;
    if(A<0)
    neg=-1;
    A=abs(A);
    while(A>0)
    {
        rev=(long long)rev*10+A%10;
        A=A/10;
    }
    if(rev>INT_MAX){
    return 0;
    }
    return neg*(int)rev;
}

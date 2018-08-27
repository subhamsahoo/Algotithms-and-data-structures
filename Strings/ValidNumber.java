/*

Validate if a given string is numeric.

Examples:

"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Clarify the question using “See Expected Output”

Is 1u ( which may be a representation for unsigned integers valid?
For this problem, no.
Is 0.1e10 valid?
Yes
-01.1e-10?
Yes
Hexadecimal numbers like 0xFF?
Not for the purpose of this problem
3. (. not followed by a digit)?
No
Can exponent have decimal numbers? 3e0.1?
Not for this problem.
Is 1f ( floating point number with f as prefix ) valid?
Not for this problem.
How about 1000LL or 1000L ( C++ representation for long and long long numbers )?
Not for this problem.
How about integers preceded by 00 or 0? like 008?
Yes for this problem

*/

int Solution::isNumber(const string A) {
    int length=A.length();
    if(length==0)
    return 0;
    int i=0,j=length-1;
    while(A[i]==' '&&i<length){
    i++;
    }
    if(i>=length)
    return 0;
    while(A[j]==' '&&j>=0)
    j--;
    if(j<0)
    return 0;
    int decimal=0,number=0,e=0;
    int start=i;
    while(i<=j)
    {
        int temp=A[i]-48;
        if(A[i]=='.')
        {
            if(decimal==1||e==1)
            return 0;
            if(i==j)
            return 0;
            decimal=1;
        }
        else if(start==i&&(A[i]=='+'||A[i]=='-')&&i!=j);
        else if(A[i]=='e')
        {
            if(A[i-1]=='.')
            return 0;
            e=1;
            if(number==0)
            return 0;
            else
            {
                if(A[i+1]=='+'||A[i+1]=='-')
                i++;
                if(A[i+1]=='\0')
                return 0;
            }
        }
        else if(temp>=0&&temp<10)
            number=1;
        else
        return 0;
        i++;
    }
    if(A[j]=='.')
    return 0;
    return 1;
}

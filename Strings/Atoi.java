/*

Implement atoi to convert a string to an integer.

Example :

Input : "9 2704"
Output : 9
Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

 Questions: Q1. Does string contain whitespace characters before the number?
A. Yes Q2. Can the string have garbage characters after the number?
A. Yes. Ignore it. Q3. If no numeric character is found before encountering garbage characters, what should I do?
A. Return 0. Q4. What if the integer overflows?
A. Return INT_MAX if the number is positive, INT_MIN otherwise. 

*/

int Solution::atoi(const string A) {
    int start,i=0,neg=1,prev;
    long long int num=0;
    while(A[i]==' ')
    i++;
    start=i;
    while(A[i]!='\0')
    {
        int temp=(int)A[i]-48;
        if(temp>=0&&temp<=9){
            num=num*10+temp;
            
        if(num>INT_MAX)
        {
            if(neg==-1)
            return INT_MIN;
            return INT_MAX;
        }
        }
        else
        {
            if(i==start)
            {
                if(A[i]=='-')
                neg=-1;
                else if(A[i]=='+');
                else
                break;
            }
            else
                break;
        }
        i++;
    }
    return neg*(int)num;
}

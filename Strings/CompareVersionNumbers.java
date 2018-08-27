/*

Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 1.13 < 1.13.4

*/


int Solution::compareVersion(string A, string B) {
   unsigned long long int num1,num2;
    int i=0,j=0;
    while(A[i]!='\0'||B[j]!='\0')
    {
        num1=0;
        num2=0;
        while(A[i]!='\0'&&A[i]!='.'){
        num1=num1*10+A[i]-48;
        i++;
        }
        if(A[i]!='\0')
        i++;
        while(B[j]!='\0'&&B[j]!='.'){
        num2=num2*10+B[j]-48;
        j++;
        }
        if(B[j]!='\0')
        j++;   
    //    cout<<num1<<"  "<<num2<<endl;
        if(num1>num2)
        return 1;
        else if(num2>num1)
        return -1;

    }
        if(num1>num2)
        return 1;
        else if(num2>num1)
        return -1;
        return 0;
}

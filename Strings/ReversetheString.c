/*

Given an input string, reverse the string word by word.

Example:

Given s = "the sky is blue",

return "blue is sky the".

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.

*/

/**
 * @input A : String termination by '\0'
 * 
 * @Output Void. Just modifies the args passed by reference 
 *
 */
 
 void reverse(char* A,int start,int end)
 {
    while(start<end)
    {
        char temp=A[start];
        A[start]=A[end];
        A[end]=temp;
        start++;
        end--;               
    }
 }
 
void reverseWords(char* A) {
    int i=0,j;
    int count=0,start=-1,end;
    while(A[i]!='\0')
    {
        if(A[i]==' ')
        {
            if(i==0)
            start=0;
            while(A[i]==' ')
            i++;
            if(start==0||A[i]=='\0')
            start=-1;
            else
            A[count++]=' ';
        }
        else
            A[count++]=A[i++];
    }
    A[count]='\0';
    i=0;
    j=count-1;
    reverse(A,i,j);
    start=0;
    i=0;
    while(1)
    {
        if(A[i]=='\0')
        {
            end=i-1;
            reverse(A,start,end);
            break;
        }
        else if(A[i]!=' ')
        i++;
        else
        {
            end=i-1;
            reverse(A,start,end);
            i++;
            start=i;
        }
    }
    
    
}

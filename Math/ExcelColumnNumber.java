/*


Given a column title as appears in an Excel sheet, return its corresponding column number.

Example:

    A -> 1
    
    B -> 2
    
    C -> 3
    
    ...
    
    Z -> 26
    
    AA -> 27
    
    AB -> 28 

	
*/

/**
 * @input A : String termination by '\0'
 * 
 * @Output Integer
 */
int titleToNumber(char* A) {
    int length=0,i;
    for(i=0;A[i]!='\0';i++);
    length=i;
    int result=0,mul=1;
    for(i=length-1;i>=0;i--)
    {
        result=result+(mul*(A[i]-64));
        mul=mul*26;
    }
    return result;
}

/*

Given a positive integer which fits in a 32 bit signed integer, find if it can be expressed as A^P where P > 1 and A > 0. A and P both should be integers.

Example

Input : 4
Output : True  
as 2^2 = 4. 

*/

/**
 * @input A : Integer
 * 
 * @Output Integer
 */
int isPower(int A) {
    int i,j;
    if(A == 1){
        return 1;
    }
    
    for(i = 2; i < 32; i++){
        for(j = 2; j <= pow(INT_MAX, 1.0/i); j++){
            if(pow(j, i) == A){
                return 1;
            }
        }
    }
    return 0;
}

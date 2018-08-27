/*


Write a function to find the longest common prefix string amongst an array of strings.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

Example:

Given the array as:

[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
  
]

The answer would be “a”.

*/


/**
 * @input A : array of strings termination by '\0'
 * @input n1 : number of strings in array A
 * 
 * @Output string. Make sure the string ends with null character
 */
char* longestCommonPrefix(char** A, int n1) {
        int i,j;
        for(i=0;A[0][i]!='\0';i++)
        {
            char particular=A[0][i];
            for( j=0;j<n1;j++)
            {
                if(A[j][i]=='\0'||A[j][i]!=particular)
                {
                    A[0][i]='\0';
                    return A[0];
                }
            }
        }
        A[0][i]='\0';
        return A[0];
}



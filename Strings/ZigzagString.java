/*

The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P.......A........H.......N
..A..P....L....S....I...I....G
....Y.........I........R
And then read line by line: PAHNAPLSIIGYIR
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR"
**Example 2 : **
ABCD, 2 can be written as

A....C
...B....D
and hence the answer would be ACBD.

*/

public class Solution {
    public String convert(String A, int B) {
        int length=A.length();
        if(length<=B||B==1)
        return A;
        StringBuilder result = new StringBuilder();
        int row=0,up=0,down=0,count=0;;
        for(int i=0;i<B;i++)
        {
            row=i;
            if(i==0||i==B-1)
            {
                up=(B-1)*2;
                down=(B-1)*2;
            }
            else
            {
                down=(B-i-1)*2;
                up=i*2;
            }
            count=1;
            while(row<length)
            {
                result.append(A.charAt(row));
                if(count%2==0)
                row=row+up;
                else
                row=row+down;
                count++;
            }
        }
        return result.toString();
    }
}

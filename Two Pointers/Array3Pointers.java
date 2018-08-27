/*

You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

Find i, j, k such that :
max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

**abs(x) is absolute value of x and is implemented in the following manner : **

      if (x < 0) return -x;
      else return x;
Example :

Input : 
        A : [1, 4, 10]
        B : [2, 15, 20]
        C : [10, 12]

Output : 5 
         With 10 from A, 15 from B and 10 from C. 
		 
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int maximum=Integer.MAX_VALUE;
        int i=0,j=0,k=0;
        while(i<A.size()&&j<B.size()&&k<C.size())
        {
            int temp1=Math.abs(A.get(i)-B.get(j));
            int temp2=Math.abs(B.get(j)-C.get(k));
            int temp3=Math.abs(A.get(i)-C.get(k));
            int m=Math.max(temp1,Math.max(temp2,temp3));
            if(m<maximum)
            maximum=m;
            if(m==temp1)
            {
                if(A.get(i)>B.get(j))
                j++;
                else
                i++;
            }
            else if(m==temp2)
            {
                if(B.get(j)>C.get(k))
                k++;
                else
                j++;
            }
            else if(m==temp3)
            {
                if(A.get(i)>C.get(k))
                k++;
                else
                i++;
            }
        }
        return maximum;
    }
}

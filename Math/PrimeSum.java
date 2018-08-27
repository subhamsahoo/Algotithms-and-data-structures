/*


Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.

NOTE A solution will always exist. read Goldbach’s conjecture

Example:


Input : 4
Output: 2 + 2 = 4

If there are more than one solutions possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b,
and [c,d] is another solution with c <= d, then

[a, b] < [c, d] 

If a < c OR a==c AND b < d. 


*/

public class Solution {
    
    ArrayList<Integer> primeNumbers(int A)
    {
        ArrayList<Integer> result=new ArrayList<>();
        boolean[] primes=new boolean[A+1];
        for(int i=2;i<=Math.sqrt(A);i++)
        {
            if(primes[i]==false)
            {
                int num=i+i;
                while(num<=A)
                {
                    primes[num]=true;
                    num=num+i;
                }
            }
        }
        for(int i=2;i<=A;i++)
        {
            if(primes[i]==false)
            result.add(i);
        }
        return result;
    }
    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> primes=primeNumbers(A);
        ArrayList<Integer> result=new ArrayList<Integer>();
        int i=0,j=primes.size()-1,num1=0,num2=0;
        while(i<=j)
        {
            num1=primes.get(i);
            num2=primes.get(j);
            if(num1+num2==A)
            {
                result.add(num1);
                result.add(num2);
                return result;
            }
            else if(num1+num2>A)
            j--;
            else
            i++;
        }
        return result;
    }
}

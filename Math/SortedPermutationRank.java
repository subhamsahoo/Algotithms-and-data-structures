/*

Given a string, find the rank of the string amongst its permutations sorted lexicographically. 
Assume that no characters are repeated.

Example :

Input : 'acb'
Output : 2

The order permutations with letters 'a', 'c', and 'b' : 
abc
acb
bac
bca
cab
cba
The answer might not fit in an integer, so return your answer % 1000003

*/

public class Solution {
    public int findRank(String A) {
        ArrayList<Integer> data = new ArrayList();
        for(int i=0;i<A.length();i++)
        data.add((int)A.charAt(i)-96);
        Collections.sort(data);
        int[] fac=new int[A.length()];
        fac[0]=1;
        for(int i=1;i<fac.length;i++)
        fac[i]=(fac[i-1]*i)%1000003;
        int result=1;
        int position=fac.length-1;
        for(int i=0;i<A.length()-1;i++)
        {
            int temp=(int)A.charAt(i)-96;
            for(int j=0;j<data.size();j++)
            {
                if(data.get(j)==temp)
                {
                    result=(result+((j*fac[position])%1000003))%1000003;
                    position--;
                    data.remove(j);
                    break;
                }
            }
        }
        return result;
    }
}

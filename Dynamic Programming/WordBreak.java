/*

Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given

s = "myinterviewtrainer",
dict = ["trainer", "my", "interview"].
Return 1 ( corresponding to true ) because "myinterviewtrainer" can be segmented as "my interview trainer".

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

*/

public class Solution {
    public int wordBreak(String A, ArrayList<String> B) {
        HashSet<String> dictionary = new HashSet<>(B);
        int[] cache=new int[A.length()+1];
        cache[A.length()]=1;
        for(int i=A.length()-1;i>=0;i--)
        {
            StringBuilder temp=new StringBuilder();
            for(int j=i;j<A.length();j++)
            {
             temp.append(A.charAt(j));
                if(dictionary.contains(temp.toString()))
                {
                    if(cache[j+1]==1){
                    cache[i]=1;
                    break;
                    }
                }
            }
            
        }
        return cache[0];
    }
}

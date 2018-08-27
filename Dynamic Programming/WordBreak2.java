/*

Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given

s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].
A solution is

[
  "cat sand dog", 
  "cats and dog"
]
Make sure the strings are sorted in your result.

*/


public class Solution {
    public ArrayList<String> wordBreak(String A, ArrayList<String> B) {
        HashSet<String> dictionary = new HashSet<>(B);
        result[] cache=new result[A.length()+1];
        for(int i=0;i<=A.length();i++)
            cache[i]=new result();
        cache[A.length()].found=1;
        for(int i=A.length()-1;i>=0;i--)
        {
            StringBuilder temp=new StringBuilder();
            for(int j=i;j<A.length();j++)
            {
             temp.append(A.charAt(j));
                if(dictionary.contains(temp.toString()))
                {
                    if(j+1==A.length()){
                        cache[i].word.add(temp.toString());
                        cache[i].found=1;
                    }
                    else if(cache[j+1].found==1){
                        for(int k=0;k<cache[j+1].word.size();k++){
                            cache[i].word.add(temp.toString()+" "+cache[j+1].word.get(k));
                        }
                         cache[i].found=1;
                    }
                }
            }
            
        }
        return cache[0].word;
    }
}

class result
{
    int found;
    ArrayList<String> word;
    result()
    {
        found=0;
        word=new ArrayList<String>();
    }
}

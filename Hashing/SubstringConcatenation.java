/*

You are given a string, S, and a list of words, L, that are all of the same length.

Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

Example :

S: "barfoothefoobarman"
L: ["foo", "bar"]
You should return the indices: [0,9].
(order does not matter).

*/


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
          int noOfWords=B.size();
        int lengthOfWord=B.get(0).length(),lengthOfString=A.length();
        ArrayList<Integer> result=new ArrayList<>();
        Map<String,Integer> checking = new HashMap<>();
        int i=0;
        while(i<noOfWords)
        {
            if(checking.containsKey(B.get(i)))
                checking.put(B.get(i),checking.get(B.get(i))+1);
            else
                checking.put(B.get(i),1);
            i++;
        }
        
        i=0;
        int start=0,count=0;
        String word="";
        while(i<=lengthOfString-(noOfWords*lengthOfWord))
        {
            word=A.substring(i,i+lengthOfWord);
           // System.out.println(word);
            count=0;
            if(checking.containsKey(word))
            {
                //System.out.println(word);
                int j=i;
                Map<String,Integer> sequence = new HashMap<>();
                while(true)
                {
                    if(checking.containsKey(word))
                    {
                        if(sequence.containsKey(word))
                            sequence.put(word,sequence.get(word)+1);
                        else
                            sequence.put(word,1);
                        if(sequence.get(word)>checking.get(word))
                            break;
                        else
                            count++;
                        if(count==noOfWords)
                        {
                            result.add(i);
                            break;
                        }
                    }
                    else
                        break;
                    j=j+lengthOfWord;
                    if((j+lengthOfWord)<=lengthOfString)
                        word=A.substring(j,j+lengthOfWord);
                    else
                        break;
                }
                    
            }
            i=i+1;
            
        }
        
        return result;

    }
}

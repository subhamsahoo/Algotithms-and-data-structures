/*

Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”, you need to sort the 
reviews in descending order according to their “Goodness Value” (Higher goodness value first). 
We define the “Goodness Value” of a string as the number of “Good Words” in that string.

Note: Sorting should be stable. If review i and review j have the same “Goodness Value” then their original order would be preserved.

 You are expected to use Trie in an Interview for such problems 

Constraints:

1.   1 <= No.of reviews <= 200
2.   1 <= No. of words in a review <= 1000
3.   1 <= Length of an individual review <= 10,000
4.   1 <= Number of Good Words <= 10,000
5.   1 <= Length of an individual Good Word <= 4
6.   All the alphabets are lower case (a - z)
Input:

S : A string S containing "Good Words" separated by  "_" character. (See example below)
R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.
Output:

A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews. 

V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)
Example:

Input: 
S = "cool_ice_wifi"
R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]

Output:
ans = [2, 0, 1]
Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]

*/

public class Solution {
    
class trieNode
{
    int count;
    Map<Character,trieNode> childrens;
    public trieNode()
    {
        childrens = new HashMap<>();
        count=0;
    }
}


class trie
{
    trieNode root;
    public trie()
    {
        root = new trieNode();
    }

    public void insert(String data)
    {
        trieNode current=root;
        int i=0,length=data.length();
        for(;i<length;i++)
        {
            trieNode temp=current.childrens.get(data.charAt(i));
            if(temp==null)
                break;
            else
                current=temp;
        }
        while(i<length)
        {
            trieNode newNode = new trieNode();
            current.childrens.put(data.charAt(i),newNode);
            current=newNode;
            i++;
        }
        current.count++;
    }

    public int search(String data)
    {
        trieNode current=root;
        int i=0,length=data.length();
        for(;i<length;i++)
        {
            trieNode temp=current.childrens.get(data.charAt(i));
            if(temp==null)
                return 0;
            current=temp;
        }
        return current.count;
    }
}

    
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        trie storage = new trie();
        String[] goodWords=A.split("_");
        for(String data:goodWords)
            storage.insert(data);
        
        for(int i=0;i<B.size();i++)
        {
            String[] reviews = B.get(i).split("_");
            int count=0;
            for(String review:reviews)
                if(review.length()<5)
                if(storage.search(review)!=0)
                    count++;
                    
            temp.add(count);
        }
        
        int length=temp.size();
        
        for(int i=0;i<length;i++)
        {
            int index=0;
            for(int j=1;j<length;j++)
            {
                if(temp.get(j)>temp.get(index))
                index=j;
            }
            temp.set(index,Integer.MIN_VALUE);
            result.add(index);
        }
        
        return result;
    }
}

/*

Find shortest unique prefix to represent each word in the list.

Example:

Input: [zebra, dog, duck, dove]
Output: {z, dog, du, dov}
where we can see that
zebra = z
dog = dog
duck = du
dove = dov
 NOTE : Assume that no word is prefix of another. In other words, the representation is always possible. 

 
 */
 
 
public class Solution {
    
String data;
int index,found;
    
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
}

void search(trieNode root,int i,int length)
{
    if(i<length)
    {
    search(root.childrens.get(data.charAt(i)),i+1,length);
   if(root.childrens.size()==1&&found==0)
    {
        index=i;
    }
    else
    found=1;
    }
}

public ArrayList<String> prefix(ArrayList<String> A) {
        trie storage = new trie();
        for(String data:A)
            storage.insert(data);
        ArrayList<String> result = new ArrayList<>();
        for(String find:A)
        {
            found=0;
            data=find;
            index=data.length();
            search(storage.root.childrens.get(data.charAt(0)),1,index);
            result.add(data.substring(0,index));
        }
        
        return result;
    }
}

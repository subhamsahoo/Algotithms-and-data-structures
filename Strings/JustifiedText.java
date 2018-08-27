/*

Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line.

Pad extra spaces ‘ ‘ when necessary so that each line has exactly L characters.
Extra spaces between words should be distributed as evenly as possible.
If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.

Your program should return a list of strings, where each string represents a single line.

Example:

words: ["This", "is", "an", "example", "of", "text", "justification."]

L: 16.

Return the formatted lines as:

[
   "This    is    an",
   "example  of text",
   "justification.  "
]

*/


public class Solution {
    public ArrayList<String> fullJustify(ArrayList<String> A, int B) {
        ArrayList<String> result=new ArrayList<String>();
        int size=A.size(),i=0;
        StringBuilder temp=new StringBuilder();
        int temp2;
        while(i<size)
        {
            
            int count=0,start=i,end=i,occupied=0;
            while(i<size&&occupied+count+A.get(i).length()<=B)
            {
                occupied=occupied+A.get(i).length();
                i++;
                count++;
            }
            end=i-1;
            if(i>=size)
            {
                while(start<=end)
                {
                    temp.append(A.get(start));
                    if(start!=end)
                    temp.append(" ");
                    start++;
                }
                temp2=B-occupied-(count-1);
                while(temp2>0)
                {
                    temp.append(" ");
                    temp2--;
                }
            }
            else
            {
                int holes=count-1;
                temp2=B-occupied;
                int fill=0,extra=0;
                if(holes>0){
                fill=temp2/holes;
                extra=temp2%holes;
                }
                while(start<=end)
                {
                    temp.append(A.get(start));
                    if(start!=end)
                    {
                        int no_of_spaces=fill;
                        if(extra>0)
                        {
                            no_of_spaces++;
                            extra--;
                        }
                        for(int s=1;s<=no_of_spaces;s++)
                        temp.append(" ");
                    }
                    start++;
                }
                if(count==1)
                {
                    for(int s=1;s<=temp2;s++)
                    temp.append(" ");
                }
            }
            result.add(temp.toString());
            int length=temp.length();
            temp.delete(0,length);
            
        }
        return result;
    }
}

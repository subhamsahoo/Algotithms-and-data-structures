/*

Given a digit string, return all possible letter combinations that the number could represent.

The digit 0 maps to 0 itself.
The digit 1 maps to 1 itself.
The digit 2 maps to abc
The digit 3 maps to def
The digit 4 maps to ghi
The digit 5 maps to jkl
The digit 6 maps to mno
The digit 7 maps to pqrs
The digit 8 maps to tuv
The digit 9 maps to wxyz

Input: Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Make sure the returned strings are lexicographically sorted.

*/


public class Solution {
    ArrayList<String> mapping(int num)
    {
        ArrayList<String> data = new ArrayList<>();
        if(num==0||num==1)
        {
            data.add(Character.toString ((char)(num+48)));
        }
        if(num>=2&&num<=6)
        {
            num=num-2;
            int start=97+(num*3);
            for(int i=1;i<=3;i++)
            {
                data.add(Character.toString ((char) start));
                start++;
            }
        }
        else if(num==7)
        {
            int start=112;
            for(int i=1;i<=4;i++)
            {
                data.add(Character.toString ((char) start));
                start++;
            }
        }
        else if(num==8)
        {
            int start=116;
            for(int i=1;i<=3;i++)
            {
                data.add(Character.toString ((char) start));
                start++;
            }
        }
        else if(num==9)
        {
            int start=119;
            for(int i=1;i<=4;i++)
            {
                data.add(Character.toString ((char) start));
                start++;
            }
        }        
        return data;
    }
    
    ArrayList<String> combinations(String digits,int current)
    {
        ArrayList<String> result = new ArrayList<>();
        if(current<digits.length()){
        if(digits.length()-current==1)
            return mapping((int)digits.charAt(current)-48);
        else
        {
            ArrayList<String> temp2=combinations(digits,current+1);
            ArrayList<String> temp1=mapping((int)digits.charAt(current)-48);
            int l1=temp1.size(),l2=temp2.size();
            for(int i=0;i<l1;i++)
            {
                for(int j=0;j<l2;j++)
                {
                    result.add(temp1.get(i)+temp2.get(j));
                }
            }
            return result;
        }
        }
        return result;
    }
    public ArrayList<String> letterCombinations(String A) {
        return combinations(A,0);
    }
}

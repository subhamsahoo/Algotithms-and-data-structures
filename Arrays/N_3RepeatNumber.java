/*


You’re given a read only array of n integers. Find out if any integer occurs more than n/3 times in the array in linear time and constant additional space.

If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.

Example :

Input : [1 2 3 1 1]
Output : 1 
1 occurs 3 times which is more than 5/3 times. 


*/


public class Solution {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        int num1=Integer.MAX_VALUE,num2=Integer.MAX_VALUE,count1=0,count2=0;
        int length=a.size();
        for(int i=0;i<length;i++)
        {
            if(num1==a.get(i))
                count1++;
            else if(num2==a.get(i))
                count2++;
            else
            {
                if(count1>0&&count2>0)
                {
                    count1--;
                    count2--;
                }
                else if(count1==0)
                {
                    num1=a.get(i);
                    count1=1;
                }
                else
                {
                    num2=a.get(i);
                    count2=1;
                }
            }
        }
        
        int majority=(length/3)+1;
        count1=0;
        count2=0;
        for(int i=0;i<length;i++)
        {
            if(num1==a.get(i))
                count1++;
            else if(num2==a.get(i))
                count2++;
        }
        if(count1>=majority)
            return num1;
        if(count2>=majority)
            return num2;
        return -1;
    }
}

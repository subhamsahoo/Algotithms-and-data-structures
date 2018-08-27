/*

Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Example :

Input : [1 2]
Return :  1

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxProfit(final List<Integer> A) {
        int result=0;
        int i=0,m1=-1,m2=-1;
        for(i=0;i<A.size()-1;i++)
        {
            if(A.get(i)<A.get(i+1))
            {
                m1=A.get(i);
                i++;
                break;
            }
        }
        if(m1==-1)
            return 0;
        for(;i<A.size();i++)
        {
            if(A.get(i)<m1)
            {
                if(m2==-1)
                    m1=A.get(i);
                else
                {
                    if((m2-m1)>result)
                        result=m2-m1;
                    m1=A.get(i);
                    m2=-1;
                }
            }
            else if(A.get(i)>m2)
                m2=A.get(i);
        }
        if(m2!=-1)
        {
            if((m2-m1)>result)
                result=m2-m1;
        }
        return result;

        
    }
}

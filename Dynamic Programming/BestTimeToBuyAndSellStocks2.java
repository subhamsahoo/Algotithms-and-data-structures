/*

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example :

Input : [1 2 3]
Return : 2

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
                    result=result+(m2-m1);
                    m1=A.get(i);
                    m2=-1;
                }
            }
            else if(A.get(i)>m2)
                m2=A.get(i);
            else if(A.get(i)>=m1&&A.get(i)<m2)
            {
                result=result+(m2-m1);
                m1=A.get(i);
                m2=-1;
            }
        }
        if(m2!=-1)
            result=result+(m2-m1);
        return result;


    }
}

/*

As it is Tushar’s Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune.
Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity. Find the minimum cost such that all of Tushar’s friends are satisfied (reached their eating capacity).

NOTE:

Each dish is supposed to be eaten by only one person. Sharing is not allowed.
Each friend can take any dish unlimited number of times.
There always exists a dish with filling capacity 1 so that a solution always exists.
Input Format

Friends : List of integers denoting eating capacity of friends separated by space.
Capacity: List of integers denoting filling capacity of each type of dish.
Cost :    List of integers denoting cost of each type of dish.
Constraints:
1 <= Capacity of friend <= 1000
1 <= No. of friends <= 1000
1 <= No. of dishes <= 1000

Example:

Input:
    2 4 6
    2 1 3
    2 5 3

Output:
    14

Explanation: 
    First friend will take 1st and 2nd dish, second friend will take 2nd dish twice.  Thus, total cost = (5+3)+(3*2)= 14
	
	
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int result=0;
        int max=A.get(0);
        for(int i=0;i<A.size();i++)
            if(A.get(i)>max)
                max=A.get(i);
        for(int i=0;i<A.size();i++){
            int[] cache=new int[max+1];
            result=result+cost(B,C,A.get(i),cache);
        }
        return result;    
    }
    
    int cost(final List<Integer> B,final List<Integer> C,int capacity,int[] cache)
    {
        if(capacity==0)
        return 0;
        if(cache[capacity]!=0)
        return cache[capacity];
        int minCost=Integer.MAX_VALUE;
        for(int i=0;i<B.size();i++)
        {
            if(B.get(i)<=capacity)
            {
                int temp=C.get(i)+cost(B,C,capacity-B.get(i),cache);
                if(temp<minCost)
                minCost=temp;
            }
        }
        cache[capacity]=minCost;
        return cache[capacity];
    }
}
	
/*

Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Largest Rectangle in Histogram: Example 1

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

Largest Rectangle in Histogram: Example 2

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.

*/


public class Solution {
    public int largestRectangleArea(ArrayList<Integer> A) {

         int result=0;
        Stack<Integer> s = new Stack();
        for(int i=0;i<A.size();i++)
        {
            if(s.empty()||A.get(s.peek())<A.get(i))
                s.push(i);
            else
            {
                while(!s.empty()&&A.get(s.peek())>A.get(i))
                {
                    int h=A.get(s.pop());
                    int left=-1;
                    if(!s.empty())
                        left=s.peek();
                    result=Math.max(result,(i-left-1)*h);
                }

                    s.push(i);
            }
        }
        int right=A.size();
        while(!s.empty())
        {
            int h=A.get(s.pop());
            int left=-1;
            if(!s.empty())
                left=s.peek();
            result=Math.max(result,(right-left-1)*h);   
        }
        return result;
    }
}

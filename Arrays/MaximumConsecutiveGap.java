/*

Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Try to solve it in linear time/space.

Example :

Input : [1, 10, 5]
Output : 5 
Return 0 if the array contains less than 2 elements.

You may assume that all the elements in the array are non-negative integers and fit in the 32-bit signed integer range.
You may also assume that the difference will not overflow.

*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        Set<Integer> data = new TreeSet<>();
        for(int i=0;i<A.size();i++)
            data.add(A.get(i));
        int prev=-1,diff=0;
      Iterator iterator=data.iterator();
      while (iterator.hasNext()) {
          if(prev==-1)
            prev=(int)iterator.next();
        else
        {
            int temp=(int)iterator.next();
            if(temp-prev>diff)
                diff=temp-prev;
            prev=temp;
        }
      }
        return diff;
    }
}

/*

A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window. The following example will give you more clarity.

Example :

The array is [1 3 -1 -3 5 3 6 7], and w is 3.

Window position	Max
 	 
[1 3 -1] -3 5 3 6 7	3
1 [3 -1 -3] 5 3 6 7	3
1 3 [-1 -3 5] 3 6 7	5
1 3 -1 [-3 5 3] 6 7	5
1 3 -1 -3 [5 3 6] 7	6
1 3 -1 -3 5 [3 6 7]	7
Input: A long array A[], and a window width w
Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
Requirement: Find a good optimal way to get B[i]

 Note: If w > length of the array, return 1 element with the max of the array. 
 
 */
 
 public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    int rear,top;
    
    boolean isEmpty()
    {
        if((rear==-1&&top==-1)||rear>top)
            return false;
        return true;
    }
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        int length=A.size();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> dequeue = new ArrayList<>();
        rear=top=-1;
        if(B==0||length==0)
        return result;
        if(length<B)
        {
            int max=A.get(0);
            for(int i=1;i<length;i++)
                if(A.get(i)>max)
                    max=A.get(i);
            result.add(max);
            return result;
        }
        for(int i=0;i<B;i++)
        {
            while(isEmpty()&&A.get(dequeue.get(top))<=A.get(i)){
                dequeue.remove(top);
                top--;
            }
            if(rear==-1&&top==-1)
            {
                rear++;
                top++;
            }
            else
                top++;
            dequeue.add(i);
           // System.out.println(A.get(dequeue.get(rear))+" "+rear+" "+top);
        }
        result.add(A.get(dequeue.get(rear)));
        int delete=0;
        for(int i=B;i<length;i++)
        {
            while(isEmpty()&&A.get(dequeue.get(top))<=A.get(i))
            {
                dequeue.remove(top);
                top--;
            }
            top++;
            dequeue.add(i);         
            if(dequeue.get(rear)<=delete)
            rear++;
            result.add(A.get(dequeue.get(rear)));
            delete++;
        }
       return result; 
      
    }
}

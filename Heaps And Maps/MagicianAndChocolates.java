/*

Given N bags, each bag contains Ai chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.

Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.

For example,

K = 3
N = 2
A = 6 5

Return: 14
At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
so, total number of chocolates eaten: 6 + 5 + 3 = 14

Note: Return your answer modulo 10^9+7

*/

class heap
{
    int heapLength;
    public heap()
    {
        heapLength=0;
    }

    public void buildHeap(ArrayList<Integer> a)
    {
             heapLength=a.size();
             for(int i=(heapLength/2)-1;i>=0;i--)
                 maxHeapify(a,i);
    }

    public void maxHeapify(ArrayList<Integer> A,int index)
    {
        int left=(index+1)*2-1;
        int right=(index+1)*2;
        int largest=index;
        if(left<heapLength&&A.get(left)>A.get(largest))
            largest=left;
        if(right<heapLength&&A.get(right)>A.get(largest))
            largest=right;
        if(largest!=index)
        {
            int temp=A.get(largest);
            A.set(largest,A.get(index));
            A.set(index,temp);
            maxHeapify(A,largest);
        }

    }

    public void extractMax(ArrayList<Integer> a)
    {
        int replace=a.get(0)/2;
        if(replace>0)
        a.set(0,replace);
        else{
        a.set(0,a.get(heapLength-1));
        heapLength--;
        }
        maxHeapify(a,0);
    }
}




public class Solution {
    
    public int nchoc(int A, ArrayList<Integer> B) {
        long result=0L;
        heap h=new heap();
        h.buildHeap(B);
       /* for(int i=0;i<B.size();i++)
        System.out.print(B.get(i)+" ");
        */for(int i=0;i<A;i++)
        {
            if(h.heapLength>0)
            {
                result=(result+B.get(0))%1000000007;
                h.extractMax(B);
            }
            else
            return (int)result;
        }
        return (int)result;
    }
}

/*

Merge k sorted linked lists and return it as one sorted list.

Example :

1 -> 10 -> 20
4 -> 11 -> 13
3 -> 8 -> 9
will result in

1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20

*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */

class heap
{
    int heapLength;
    public heap()
    {
        heapLength=0;
    }

        public void buildHeap(ListNode a[])
    {
             heapLength=a.length;
             for(int i=(heapLength/2)-1;i>=0;i--)
                 maxHeapify(a,i);
    }
    
    public void maxHeapify(ListNode A[],int index)
    {
        int left=(index+1)*2-1;
        int right=(index+1)*2;
        int largest=index;
        if(left<heapLength&&A[left].val<A[largest].val)
            largest=left;
        if(right<heapLength&&A[right].val<A[largest].val)
            largest=right;
        if(largest!=index)
        {
            ListNode temp=A[largest];
            A[largest]=A[index];
            A[index]=temp;
            maxHeapify(A,largest);
        }
    }
    
    public ListNode extractMax(ListNode a[])
    {
        if(heapLength==0)
            return null;
        ListNode max=a[0];
        if(max.next!=null)
            a[0]=max.next;
        else{
        a[0]=a[heapLength-1];
        heapLength--;
        }
        maxHeapify(a,0);
        return max;
    }
    
}

public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
         int kListLength=a.size();
        ListNode data[] = new ListNode[kListLength];
        for(int i=0;i<kListLength;i++)
            data[i]=a.get(i);
        heap h=new heap();
        h.buildHeap(data);
        ListNode root=null,current=null;
        while(true)
        {
            ListNode temp=h.extractMax(data);
            if(temp!=null)
            {
            if(root==null){
            root=temp;
            current=temp;
            }
            else
            {
                current.next=temp;
                current=current.next;
            }
            }
            else
                break;
        }
        
        return root;

    }
}


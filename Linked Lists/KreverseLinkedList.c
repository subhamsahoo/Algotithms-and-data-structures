/*

Given a singly linked list and an integer K, reverses the nodes of the

list K at a time and returns modified linked list.

 NOTE : The length of the list is divisible by K 
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,

You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5

Try to solve the problem using constant extra space.

*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode A, int B) {
        if(A==null)
    return A;
    ListNode temp=A,prev=null,start,current;
    int i;
        start=temp;
        for(i=0;i<B;i++)
        {
            current=temp;
            temp=temp.next;
            current.next=prev;
            prev=current;
        }
        start.next=temp;
        A=prev;
        
    while(temp!=null)
    {
        prev=null;
        ListNode currentStart=temp;
        for(i=0;i<B;i++)
        {
            current=temp;
            temp=temp.next;
            current.next=prev;
            prev=current;
        }
        start.next=prev;
        currentStart.next=temp;
        start=currentStart;
    }
    temp=A;
    
        /*while(temp!=NULL)
        {
            printf("%d ",temp->val);
            temp=temp.next;
        }*/
        return temp;
    }
}

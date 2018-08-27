/*

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 

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
    public ListNode detectCycle(ListNode a) {
        ListNode p=a,q=a;
        while(p!=null&&q!=null&&q.next!=null)
        {
            p=p.next;
            q=q.next.next;
            if(p==q)
            break;
        }
        if(p==q)
        {
            p=a;
            while(p!=q)
            {
                p=p.next;
                q=q.next;
            }
            return p;
        }
        return null;
    }
}

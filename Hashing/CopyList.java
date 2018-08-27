/*

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

Return a deep copy of the list.

Example

Given list

   1 -> 2 -> 3
with random pointers going from

  1 -> 3
  2 -> 1
  3 -> 1
You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. 
The pointers in the returned list should not link to any node in the original input list.

*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return null;
        RandomListNode current = head,copyRoot=null,copyCurrent=null;
        Map<RandomListNode,RandomListNode> storage = new HashMap<>();
        while(current!=null)
        {
            RandomListNode newNode = new RandomListNode(current.label);
            if(copyRoot==null)
            {
                copyRoot=newNode;
                copyCurrent=newNode;
            }
            else
            {
                copyCurrent.next=newNode;
                copyCurrent=copyCurrent.next;
            }
            storage.put(current,newNode);
            current=current.next;
        }
        
        current=head;
        copyCurrent=copyRoot;
        while(current!=null)
        {
            if(current.random!=null)
            {
                RandomListNode temp=storage.get(current.random);
                copyCurrent.random=temp;
            }
            current=current.next;
            copyCurrent=copyCurrent.next;
        }
        
        return copyRoot;

        
    }
}

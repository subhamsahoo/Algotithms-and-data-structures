/*

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

 A height balanced BST : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Example :


Given A : 1 -> 2 -> 3
A height balanced BST  :

      2
    /   \
   1     3

   
 */
 
 
 /**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
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
    
    TreeNode head;
    
    void bst(TreeNode root,int data)
    {
        TreeNode newNode = new TreeNode(data);
        if(head==null)
        head=newNode;
        else
        {
            if(data<root.val)
            {
                if(root.left==null)
                root.left=newNode;
                else
                bst(root.left,data);
            }
            else
            {
                if(root.right==null)
                root.right=newNode;
                else
                bst(root.right,data);                
            }
        }
        
    }
    
    void binarySearch(ArrayList<Integer> a,int start,int end)
    {
        if(start<=end)
        {
        int mid = end + (start-end)/2;
        bst(head,a.get(mid));
        binarySearch(a,start,mid-1);
        binarySearch(a,mid+1,end);
        }
    }
    public TreeNode sortedListToBST(ListNode a) {
        ArrayList<Integer> data=new ArrayList<>();
        ListNode temp=a;
        while(temp!=null)
        {
            data.add(temp.val);
            temp=temp.next;
        }
        head=null;
        binarySearch(data,0,data.size()-1);
        return head;
        
    }
}

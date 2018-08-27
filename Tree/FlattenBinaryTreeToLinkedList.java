/*

Given a binary tree, flatten it to a linked list in-place.

Example :
Given


         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Note that the left child of all nodes should be NULL.
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
public class Solution {
    TreeNode head,current;
    void connection(TreeNode a)
    {
        if(a!=null)
        {
            TreeNode left=a.left,right=a.right;
            a.left=null;
            a.right=null;
            if(head==null)
            {
                head=a;
                current=a;
            }
            else{
            current.right=a;
            current=current.right;
            }
            connection(left);
            connection(right);
        }
    }
    public TreeNode flatten(TreeNode a) {
        head=null;
        current=null;
        connection(a);
        return head;
    }
}

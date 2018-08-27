/*


Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 Note:
You may only use constant extra space.
Example :

Given the following binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 Note 1: that using recursion has memory overhead and does not qualify for constant space.
Note 2: The tree need not be a perfect binary tree. 


*/


/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeLinkNode previous;
    int height(TreeLinkNode root)
    {
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    
    void levels(TreeLinkNode root,int particularLevel)
    {
        if(root==null)
            return;
        if(particularLevel==0)
        {
            if(previous!=null)
                previous.next=root;
            previous=root;
        }
        else
        {
            levels(root.left,particularLevel-1);
            levels(root.right,particularLevel-1);
        }
    }
    public void connect(TreeLinkNode root) {
         
        int h=height(root);
        for(int i=1;i<h;i++)
        {
            previous=null;
            levels(root,i);
        }
    }
}
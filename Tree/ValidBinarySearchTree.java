/*

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
Both the left and right subtrees must also be binary search trees.
Example :

Input : 
   1
  /  \
 2    3

Output : 0 or False


Input : 
  2
 / \
1   3

Output : 1 or True 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem


*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    
    int invalid=1,previous=Integer.MIN_VALUE;    
    void check(TreeNode A)
{
    if(A!=null&&invalid==1)
    {
        check(A.left);
        if(A.val>previous)
            previous=A.val;
        else
            invalid=0;
        check(A.right);
    }
}
    public int isValidBST(TreeNode A) {
       invalid=1;
        previous=Integer.MIN_VALUE;
        check(A);
        return invalid;
    }
}

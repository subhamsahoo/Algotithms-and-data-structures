/*

Given a binary tree, determine if it is height-balanced.

 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 
          1
         / \
        2   3

Return : True or 1 

Input 2 : 
         3
        /
       2
      /
     1

Return : False or 0 
         Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
         Difference = 2 > 1. 
		 
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
    int balanced;
    int check(TreeNode A)
    {
        if(balanced==1)
        {
            if(A==null)
                return 0;
            int left=check(A.left);
            int right=check(A.right);
            if(Math.abs(left-right)>1)
                balanced=0;
            
            return 1+Math.max(left,right);
        }
        return 0;
    }
    public int isBalanced(TreeNode A) {
        balanced=1;
        check(A);
        return balanced;
    }
}

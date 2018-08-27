/*

Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

Return 0 / 1 ( 0 for false, 1 for true ) for this problem

Example :

Input : 

   1       1
  / \     / \
 2   3   2   3

Output : 
  1 or True

  
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
    
    boolean check(TreeNode A,TreeNode B)
    {
       if(A==null&&B==null)
        return true;
        if(A==null||B==null)
        return false;
        if(A.val==B.val)
        {
            if(check(A.left,B.left))
            if(check(A.right,B.right))
            return true;
            return false;
        }
        else
        return false;
    }
    
    public int isSameTree(TreeNode A, TreeNode B) {
        boolean result = check(A,B);
        /*if(result)
        return 1;
        else
        return 0;*/
        return result==true?1:0;
    }
}

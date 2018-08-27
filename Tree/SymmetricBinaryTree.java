/*

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

Example :

    1
   / \
  2   2
 / \ / \
3  4 4  3
The above binary tree is symmetric. 
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
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
      boolean check(TreeNode A,TreeNode B)
    {
       if(A==null&&B==null)
        return true;
        if(A==null||B==null)
        return false;
        if(A.val==B.val)
        {
            if(check(A.left,B.right))
            if(check(A.right,B.left))
            return true;
            return false;
        }
        else
        return false;
    }
    public int isSymmetric(TreeNode A) {
        if(A==null)
        return 0;
        boolean result = check(A.left,A.right);
        if(result)
        return 1;
        else
        return 0;
    }
}

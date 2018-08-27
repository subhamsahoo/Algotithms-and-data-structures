/*

Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Example :

Given the below binary tree,

       1
      / \
     2   3
Return 6.


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
    int result;
    public int maxPathSum(TreeNode A) {
        result=Integer.MIN_VALUE;
        find(A);
        return result;
    }
    int find(TreeNode A)
    {
        if(A==null)
        return 0;
        if(A.val>result)
        result=A.val;
        int temp1=find(A.left);
        int temp2=find(A.right);
        if(A.val+temp1>result)
        result=A.val+temp1;
        if(A.val+temp2>result)
        result=A.val+temp2;
        if(A.val+temp1+temp2>result)
        result=A.val+temp1+temp2;
        return Math.max(A.val,Math.max(A.val+temp1,A.val+temp2));
    }
}

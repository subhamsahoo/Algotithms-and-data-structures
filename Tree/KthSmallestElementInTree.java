/*

Given a binary search tree, write a function to find the kth smallest element in the tree.

Example :

Input : 
  2
 / \
1   3

and k = 2

Return : 2

As 2 is the second smallest element in the tree.
 NOTE : You may assume 1 <= k <= Total number of nodes in BST 
 
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
    
    int count,result;
    void find(TreeNode A,int B)
    {
        if(A!=null&&count<B)
        {
            find(A.left,B);
            count++;
            if(count==B)
            result=A.val;
            find(A.right,B);
        }
    }
    public int kthsmallest(TreeNode A, int B) {
        count=0;
        result=0;
        find(A,B);
        return result;
    }
}

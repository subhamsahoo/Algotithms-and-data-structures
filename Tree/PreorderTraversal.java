/*

Given a binary tree, return the preorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,2,3].

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
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int top=-1;
        TreeNode current = A;
        while(true)
        {
            if(current!=null)
            {
                result.add(current.val);
                top++;
                stack.add(current);
                current = current.left;
            }
            else if(current==null&&top!=-1)
            {
                TreeNode temp = stack.get(top);
                stack.remove(top);
                top--;
                current=temp.right;
            }
            else
            {
                return result;
            }
        }
    }
}

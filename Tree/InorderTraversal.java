/*

Given a binary tree, return the inorder traversal of its nodes’ values.

Example :
Given binary tree

   1
    \
     2
    /
   3
return [1,3,2].

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
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
        int top=-1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode current=A;
        while(true)
        {
            if(current!=null)
            {
                top++;
                stack.add(current);
                current=current.left;
            }
            else if(current==null&&top!=-1)
            {
                TreeNode temp=stack.get(top);
                result.add(temp.val);
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
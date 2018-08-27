/*

Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
Also think about a version of the question where you are asked to do a level order traversal of the tree when depth of the tree is 
much greater than number of nodes on a level.

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
 
 
 class data
{
    TreeNode child;
    int level;
    data(TreeNode child,int level)
    {
        this.child=child;
        this.level=level;
    }
    
}
 
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result=new ArrayList();
        if(A==null)
            return result;
        ArrayList<data> stack=new ArrayList<>();
        int l=1;
        stack.add(new data(A,l));
        while(stack.size()>0)
        {
            ArrayList<Integer> levelResult=new ArrayList();
            while(stack.size()>0&&stack.get(0).level==l)
            {
                data temp=stack.get(0);
                if(temp.child.left!=null)
                    stack.add(new data(temp.child.left,l+1));
                if(temp.child.right!=null)
                    stack.add(new data(temp.child.right,l+1));                
                levelResult.add(temp.child.val);
                stack.remove(0);
            }
            result.add(levelResult);
            l=l+1;
        }
        return result;
        
    }
}

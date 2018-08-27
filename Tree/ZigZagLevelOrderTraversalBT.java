/*

Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).

Example : 
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return

[
         [3],
         [20, 9],
         [15, 7]
]

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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        int count=0,direction=1;
        if(A!=null)
        {
            ArrayList<Integer> level = new ArrayList<Integer>();
            queue.add(A);
            count++;
        }
        while(count>0)
        {
            ArrayList<Integer> level = new ArrayList<Integer>();
            for(int i=0;i<count;i++)
            {
                TreeNode temp = queue.get(i);
                if(temp.left!=null)
                queue.add(temp.left);
                if(temp.right!=null)
                queue.add(temp.right);
            }
            if(direction%2==0)
            {
                for(int i=count-1;i>=0;i--)
                level.add(queue.get(i).val);
                result.add(level);
                direction++;
            }
            else
            {
                for(int i=0;i<count;i++)
                level.add(queue.get(i).val);
                result.add(level);
                direction++;
            }
            for(int i=0;i<count;i++)
            queue.remove(0);
            count=queue.size();
        }
        return result;
    }
}

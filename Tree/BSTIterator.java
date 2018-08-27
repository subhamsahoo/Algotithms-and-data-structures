/*


Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

The first call to next() will return the smallest number in BST. Calling next() again will return the next smallest number in the BST, and so on.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
Try to optimize the additional space complexity apart from the amortized time complexity. 

*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {

    Stack<TreeNode> nextMin = new Stack<>();
    public Solution(TreeNode root) {
        nextMin.clear();
        while(root!=null)
        {
            nextMin.push(root);
            root=root.left;
        }
    }

    public boolean hasNext() {
        
        if(nextMin.empty())
        return false;
        return true;
    }

    public int next() {
        TreeNode temp=nextMin.pop(),temp2;
        
        if(temp.right!=null)
        {
            temp2=temp.right;
            while(temp2!=null)
            {
                nextMin.push(temp2);
                temp2=temp2.left;
            }
        }
        return temp.val;
    }
}


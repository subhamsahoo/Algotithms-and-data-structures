/*

Two elements of a binary search tree (BST) are swapped by mistake.
Tell us the 2 values swapping which the tree will be restored.

 Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
Example :


Input : 
         1
        / \
       2   3

Output : 
       [1, 2]

Explanation : Swapping 1 and 2 will change the BST to be 
         2
        / \
       1   3
which is a valid BST      


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
    TreeNode big,small,temp;
    int previous,count;
    
    void check(TreeNode root)
    {
        if(root!=null&&count<2)
        {
            check(root.left);
            if(root.val>previous);
            else
            {
                if(big==null)
                {
                    big=temp;
                    small=root;
                }
                else
                {
                    small=root;
                }
                count++;
                    
            }
            previous=root.val;
            temp=root;
            check(root.right);
                
        }
    }
    public ArrayList<Integer> recoverTree(TreeNode A) {
        big=null;
        small=null;
        count=0;
        previous=Integer.MIN_VALUE;
        check(A);
        ArrayList<Integer> result = new ArrayList();
        result.add(small.val);
        result.add(big.val);
        return result;
    }
}

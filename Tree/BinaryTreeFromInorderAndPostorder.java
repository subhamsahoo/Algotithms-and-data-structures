/*

Given inorder and postorder traversal of a tree, construct the binary tree.

 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input : 
        Inorder : [2, 1, 3]
        Postorder : [2, 3, 1]

Return : 
            1
           / \
          2   3
		  
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
    
    int current;
    TreeNode build(ArrayList<Integer> A, ArrayList<Integer> B,int start,int end)
    {
        if(start>end)
        return null;
        int temp=B.get(current),i;
        current--;
        for(i=start;i<=end;i++)
        {
            if(A.get(i)==temp)
            break;
        }
        TreeNode newNode = new TreeNode(A.get(i));
        newNode.right=build(A,B,i+1,end);
        newNode.left=build(A,B,start,i-1);
        return newNode;
    }
    
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        current=A.size()-1;
        return build(A,B,0,A.size()-1);
    }
}

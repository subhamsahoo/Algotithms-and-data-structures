/*

Given an inorder traversal of a cartesian tree, construct the tree.

 Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree. 
 Note: You may assume that duplicates do not exist in the tree. 
Example :

Input : [1 2 3]

Return :   
          3
         /
        2
       /
      1
	  
	  
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
    
    int maxIndex(ArrayList<Integer> A,int start,int end)
    {
        int index=start;
        for(int i=start+1;i<=end;i++)
        {
            if(A.get(i)>A.get(index))
            index=i;
        }
        return index;
    }
    
    TreeNode formationOfTree(ArrayList<Integer> A,int start,int end)
    {
        if(start>end)
        return null;
        int index=maxIndex(A,start,end);
        TreeNode root=new TreeNode(A.get(index));
        root.left=formationOfTree(A,start,index-1);
        root.right=formationOfTree(A,index+1,end);
        return root;
    }
    
    public TreeNode buildTree(ArrayList<Integer> A) {
        return formationOfTree(A,0,A.size()-1);
    }
}

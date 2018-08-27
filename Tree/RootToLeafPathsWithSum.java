/*

Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.

For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
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
 
 
class data
{
    TreeNode num;
    int add;
    int direction;
    public data(TreeNode num,int add,int direction)
    {
        this.num=num;
        this.add=add;
        this.direction=direction;
    }
}
 
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<data> stack= new ArrayList<>();
        ArrayList<ArrayList<Integer>> result=new ArrayList();
        int top=-1;
        if(root==null)
            return result;
        stack.add(new data(root,root.val,0));
        top++;
        while(top!=-1)
        {
            data temp=stack.get(top);
            if(temp.num.left==null&&temp.num.right==null)
            {
                if(temp.add==sum)
                {
                ArrayList<Integer> res=new ArrayList();
                for(int i=0;i<=top;i++)
                    res.add(stack.get(i).num.val);
                result.add(res);
                }
                stack.remove(top);
                top--;
            }
            else if(temp.num.left!=null&&temp.direction==0)
            {
                stack.remove(top);
                stack.add(new data(temp.num,temp.add,1));
                stack.add(new data(temp.num.left,temp.add+temp.num.left.val,0));
                top++;
            }
            else if(temp.num.right!=null&&temp.direction<2)
            {
                stack.remove(top);
                stack.add(new data(temp.num,temp.add,2));
                stack.add(new data(temp.num.right,temp.add+temp.num.right.val,0));
                top++;
            }
            else
            {
                stack.remove(top);
                top--;
            }
        }
        return result;
        
    }
}

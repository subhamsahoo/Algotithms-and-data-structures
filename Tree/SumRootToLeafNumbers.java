/*

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers % 1003.

Example :

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.

*/

/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 * 
 * typedef struct TreeNode treenode;
 * 
 * treenode* treenode_new(int val) {
 *     treenode* node = (treenode *) malloc(sizeof(treenode));
 *     node->val = val;
 *     node->left = NULL;
 *     node->right = NULL;
 *     return node;
 * }
 */
/**
 * @input A : Root pointer of the tree 
 * 
 * @Output Integer
 */
 
 int result=0;
 
 void sum(treenode *A,int prev)
 {
     if(A!=NULL)
     {
            int temp=((prev*10)%1003+(A->val))%1003;
         if(A->left==NULL&&A->right==NULL)
         {
             result=(result+temp)%1003;
         }
         else
         {
            sum(A->left,temp);
            sum(A->right,temp);
         }
     }
 }
int sumNumbers(treenode* A) {
    result=0;
    sum(A,0);
    return result;
}

/*

Given a BST node, return the node which has value just greater than the given node.

Example:

Given the tree

               100
              /   \
            98    102
           /  \
         96    99
          \
           97
Given 97, you should return the node corresponding to 98 as thats the value just greater than 97 in the tree.
If there are no successor in the tree ( the value is the largest in the tree, return NULL).

Using recursion is not allowed.

Assume that the value is always present in the tree.

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
 * @input B : Integer
 * 
 * @Output root pointer of tree.
 */
 
 
 void check(treenode *A,int B,treenode** next)
{
    if(A!=NULL&&*next==NULL)
    {
        check(A->left,B,next);
            if(A->val>B)
            (*next)=A;
        check(A->right,B,next);
    }
}
 
treenode* getSuccessor(treenode* A, int B) {
    treenode *next=NULL;
    check(A,B,&next);
    return next;
}

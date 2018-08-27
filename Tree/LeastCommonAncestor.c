/*

Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants. 
Example :


        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2_     0        8
         /   \
         7    4
For the above tree, the LCA of nodes 5 and 1 is 3.

 LCA = Lowest common ancestor 
Please note that LCA for nodes 5 and 4 is 5.

You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
There are no duplicate values.
You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.

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
 * @input C : Integer
 * 
 * @Output Integer
 */
 
    int count=0;
    int find(treenode* A,int value,int *result)
    {
        if(A==NULL)
        return 0;
        if(A->val==value){
        result[count++]=A->val;
        return 1;
        }
        int left=find(A->left,value,result);
        if(left==1){
        result[count++]=A->val;
        return 1;
        }
        int right=find(A->right,value,result);
        if(right==1)
        {
            result[count++]=A->val;
            return 1;
        }
        return 0;
    }
 
int lca(treenode* A, int B, int C) {
    int *temp1=(int*)malloc(sizeof(int*)*100000);
    int *temp2=(int*)malloc(sizeof(int*)*100000);
        find(A,B,temp1);
        int length1=count-1;
        count=0;
        find(A,C,temp2);  
        int length2=count-1;
        int temp=-1;
        while(length1>=0&&length2>=0)
        {
            if(temp1[length1]==temp2[length2])
            temp=temp1[length1];
            else
            return temp;
            length1--;
            length2--;
        }
        return temp;
}

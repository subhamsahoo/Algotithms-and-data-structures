/*

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 * 
 * typedef struct ListNode listnode;
 * 
 * listnode* listnode_new(int val) {
 *     listnode* node = (listnode *) malloc(sizeof(listnode));
 *     node->val = val;
 *     node->next = NULL;
 *     return node;
 * }
 */
/**
 * @input A : Head pointer of linked list 
 * @input B : Integer
 * 
 * @Output head pointer of list.
 */
listnode* partition(listnode* A, int B) {
    listnode *temp=A,*left=NULL,*right=NULL,*firstRight=NULL;
    while(temp!=NULL)
    {
     if(temp->val<B)
     {
         if(left==NULL&&right==NULL){
             left=temp;
             temp=temp->next;
         }
         else if(left!=NULL&&right==NULL){
            left=left->next;
            temp=temp->next;
         }
        else if(left==NULL&&right!=NULL)
        {
            right->next=temp->next;
            temp->next=firstRight;
            A=temp;
            temp=right->next;
            left=A;
        }
        else
        {
            right->next=temp->next;
            left->next=temp;
            temp->next=firstRight;
            temp=right->next;
            left=left->next;
        }
     }
     else
     {
        if(right==NULL){
        right=temp;
        firstRight=right;
        }
        else
        right=temp;
        temp=temp->next;
     }
    }
    return A;
}

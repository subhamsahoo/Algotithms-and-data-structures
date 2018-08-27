/*

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

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
 * 
 * @Output head pointer of list.
 */
listnode* deleteDuplicates(listnode* A) {
    if(A==NULL)
    return NULL;
    listnode *temp1=A,*temp2=A->next;
    while(temp2!=NULL)
    {
        if(temp1->val==temp2->val)
        {
            listnode *del=temp2;
            temp2=temp2->next;
            temp1->next=temp2;
            del->next=NULL;
            free(del);
        }
        else
        {
            temp1=temp1->next;
            temp2=temp2->next;
        }
    }
    return A;
}

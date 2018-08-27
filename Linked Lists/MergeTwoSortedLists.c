/*

Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists, and should also be sorted.

For example, given following linked lists :

  5 -> 8 -> 20 
  4 -> 11 -> 15
The merged list should be :

4 -> 5 -> 8 -> 11 -> 15 -> 20


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
 * @input B : Head pointer of linked list 
 * 
 * @Output head pointer of list.
 */
listnode* mergeTwoLists(listnode* A, listnode* B) {
    listnode *result=NULL,*temp1=A,*temp2=B;
    while(temp1!=NULL&&temp2!=NULL)
    {
        if(temp1->val<temp2->val)
        {
            if(result==NULL)
            {
                A=temp1;
                result=temp1;
            }
            else
            {
                result->next=temp1;
                result=result->next;
            }
            temp1=temp1->next;
        }
        else
        {
            if(result==NULL)
            {
                A=temp2;
                result=temp2;
            }
            else
            {
                result->next=temp2;
                result=result->next;
            }
            temp2=temp2->next;
        }
    }
    if(temp1==NULL&&temp2!=NULL){
    if(result==NULL)
    A=temp2;
    else
    result->next=temp2;
    }
    if(temp1!=NULL&&temp2==NULL)
    {
    if(result==NULL)
    A=temp1;
    else
    result->next=temp1;
    }
    return A;
}

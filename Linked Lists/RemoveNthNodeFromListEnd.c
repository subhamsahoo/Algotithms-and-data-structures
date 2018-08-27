/*

Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
If n is greater than the size of the list, remove the first node of the list.

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
listnode* removeNthFromEnd(listnode* A, int B) {
    if(A==NULL)
    return NULL;
    int count=0;
    listnode *temp=A;
    while(temp!=NULL)
    {
        if(B==0)
        {
            if(temp->next==NULL)
            return NULL;
            if(temp->next->next==NULL)
            {
                temp->next=NULL;
                return A;
            }
        }
        count++;
        temp=temp->next;
    }
    int remove=count-B;
    if(remove>0)
    {
        listnode *prev=NULL;
        temp=A;
            while(remove>0)
            {
               remove--;
               prev=temp;
               temp=temp->next;
            }
            prev->next=temp->next;
            temp->next=NULL;
            free(temp);
            return A;
    }
    else
    return A->next;
    
}

/*


Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

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
    listnode *temp1=A,*temp2=A->next,*prev;
    prev=temp1;
    int distinct=0;
    while(temp2!=NULL)
    {
        if(temp1->val==temp2->val)
        {
            while(temp2!=NULL&&temp1->val==temp2->val)
            {
            listnode *del=temp2;
            temp2=temp2->next;
            temp1->next=temp2;
            del->next=NULL;
            free(del);
            }
            distinct=1;
        }
        else
        {
            prev=temp1;
            temp1=temp1->next;
            temp2=temp2->next;
        }
        if(distinct==1)
        {
            if(temp1==A)
            {
                A=temp2;
                listnode *del=temp1;
                del->next=NULL;
                free(del);
                temp1=temp2;
                prev=temp2;
                if(temp2!=NULL)
                temp2=temp2->next;
            }
            else
            {
                prev->next=temp2;
                listnode *del=temp1;
                del->next=NULL;
                free(del);
                temp1=temp2;
               if(temp2!=NULL)
                temp2=temp2->next; 
            }
            distinct=0;
        }
    }
    return A;

}

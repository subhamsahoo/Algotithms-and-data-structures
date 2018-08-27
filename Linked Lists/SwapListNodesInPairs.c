/*

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

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
listnode* swapPairs(listnode* A) {
    listnode *temp=A,*prev=NULL,*end,*current,*startCurrent;
    int i;
    while(temp!=NULL&&temp->next!=NULL)
    {
        startCurrent=temp;
        for(i=0;i<2;i++)
        {
        current=temp;
        temp=temp->next;
        current->next=prev;
        prev=current;
        }
        if(startCurrent==A){
        A=prev;
        }
        else
        {
            end->next=prev;
        }
        startCurrent->next=temp;
        end=startCurrent;
        prev=NULL;
    }
    return A;
}


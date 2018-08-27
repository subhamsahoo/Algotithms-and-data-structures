/*

Given a singly linked list

    L: L0 → L1 → … → Ln-1 → Ln,
reorder it to:

    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
You must do this in-place without altering the nodes’ values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.



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
 
 
 listnode* reverse(listnode* A,int count)
 {
     listnode *temp=A,*prev=NULL,*link,*current;
     while(count>0)
     {
         link=temp;
         count--;
         temp=temp->next;
     }
     while(temp!=NULL)
     {
         current=temp;
         temp=temp->next;
         current->next=prev;
         prev=current;
     }
     link->next=prev;
     return A;
 }
 
 
listnode* reorderList(listnode* A) {
    if(A==NULL)
    return A;
    int count=0;
    listnode *temp1=A,*temp2,*end;
    while(temp1!=NULL)
    {
        count++;
        temp1=temp1->next;
    }
    count=count/2+count%2;
    A=reverse(A,count);
    temp1=A;
    temp2=A;
    while(count>0)
    {
        end=temp2;
        count--;
        temp2=temp2->next;
    }
    while(temp2!=NULL)
    {
        if(temp1->next==temp2)
        return A;
        listnode *first,*second;
        first=temp1;
        second=temp2;
        temp1=temp1->next;
        temp2=temp2->next;
        first->next=second;
        second->next=temp1;
        end->next=temp2;
    }

    return A;
}

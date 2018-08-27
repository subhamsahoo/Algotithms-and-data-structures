/*

Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes:

Expected solution is linear in time and constant in space.
For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.

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
 * @Output Integer
 */
int lPalin(listnode* A) {
    int count=0;
    listnode *temp=A,*prev=NULL,*current;
    while(temp!=NULL)
    {
        count++;
        temp=temp->next;
    }
    int start;
    if(count%2==0)
    start=count/2;
    else
    start=count/2+1;
    temp=A;
    while(start>0)
    {
        current=temp;
        temp=temp->next;
        start--;
    }
   current->next=NULL;
   while(temp!=NULL)
    {
        current=temp;
        temp=temp->next;
        current->next=prev;
        prev=current;
    }
    temp=A;
    while(current!=NULL)
    {
        if(current->val!=temp->val)
        return 0;
        current=current->next;
        temp=temp->next;
    }
    return 1;
}
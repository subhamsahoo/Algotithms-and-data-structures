/*


Given a list, rotate the list to the right by k places, where k is non-negative.

For example:

Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

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
listnode* rotateRight(listnode* A, int B) {
    if(A==NULL)
    return A;
    int count=0;
    listnode *temp=A,*prev=NULL,*prev2=NULL;
    while(temp!=NULL)
    {
        count++;
        prev=temp;
        temp=temp->next;
    }
    B=B%count;
    if(B==0)
    return A;
    B=count-B;
    temp=A;
    while(B>0)
    {
        B--;
        prev2=temp;
        temp=temp->next;
    }
    prev->next=A;
    prev2->next=NULL;
    A=temp;
    return A;
}

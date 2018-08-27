/*

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

 Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. Note 2:
Usually the version often seen in the interviews is reversing the whole linked list which is obviously an easier version of this question. 

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
 * @input C : Integer
 * 
 * @Output head pointer of list.
 */
listnode* reverseBetween(listnode* A, int B, int C) {
    int count=1;
    listnode *temp=A,*prev=NULL,*end,*startCurrent;
    while(count<B)
    {
        end=temp;
        temp=temp->next;
        count++;
    }
    startCurrent=temp;
    for(count=B;count<=C;count++)
    {
        listnode *current=temp;
        temp=temp->next;
        current->next=prev;
        prev=current;
    }
    startCurrent->next=temp;
    if(B!=1){
    end->next=prev;
    }
    else
    A=prev;
    return A;
}

/*

Sort a linked list using insertion sort.

We have explained Insertion Sort at Slide 7 of Arrays

Insertion Sort Wiki has some details on Insertion Sort as well.

Example :

Input : 1 -> 3 -> 2

Return 1 -> 2 -> 3

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
listnode* insertionSortList(listnode* A) {
    if(A==NULL)
    return A;
    listnode *temp1=A->next,*temp2;
    listnode *prev1=A,*prev2;
    while(temp1!=NULL)
    {
        temp2=A;
        prev2=NULL;
        while(temp1!=temp2&&temp2->val<=temp1->val)
        {
            prev2=temp2;
            temp2=temp2->next;
        }
        if(temp1!=temp2)
        {
            prev1->next=temp1->next;
            temp1->next=temp2;

            if(prev2==NULL)
                A=temp1;
            else
                prev2->next=temp1;
            temp1=prev1->next;
        }
        else{
        prev1=temp1;
        temp1=temp1->next;
        }
    }
    return A;
}

/*

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.

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
 
listnode* reverseList(listnode* A) {
    listnode *temp=A,*current=NULL,*prev=NULL;
    while(temp!=NULL)
    {
        current=temp;
        temp=temp->next;
        current->next=prev;
        prev=current;
    }
  
    return current;
}
 
listnode* addTwoNumbers(listnode* A, listnode* B) {
    listnode *temp1=A,*temp2=B,*prev=NULL;
    int count1=0,count2=0;
    while(temp1!=NULL)
    {
        count1++;
        temp1=temp1->next;
    }
    while(temp2!=NULL)
    {
        count2++;
        temp2=temp2->next;
    }
    if(count2>count1)
    {
        temp1=A;
        A=B;
        B=temp1;
    }
    int carry=0;
    temp1=A;temp2=B;
    while(temp1!=NULL&&temp2!=NULL)
    {
        int val=temp1->val+temp2->val+carry;
        temp1->val=val%10;
        carry=val/10;
        prev=temp1;
        temp1=temp1->next;
        temp2=temp2->next;
    }

    if(temp1!=NULL&&temp2==NULL&&carry>0)
    {
        while(temp1!=NULL&&carry>0)
        {
        int val=temp1->val+carry;
        temp1->val=val%10;
        carry=val/10;
        prev=temp1;
        temp1=temp1->next;
        }
    }
        if(temp1==NULL&&temp2==NULL&&carry>0)
    {
        listnode *newnode=listnode_new(carry);
        prev->next=newnode;
    }
    
    A=reverseList(A);
    
    while(A->val==0)
    {
        listnode *del=A;
        A=A->next;
        free(del);
    }
    A=reverseList(A);
    return A;
}

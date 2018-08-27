/*

Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3

begin to intersect at node c1.

 Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

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
listnode* getIntersectionNode(listnode* A, listnode* B) {
    listnode *temp1=A,*temp2=B;
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
    temp1=A;
    temp2=B;
    if(count1>count2)
    {
        while(count1!=count2)
        {
            temp1=temp1->next;
            count1--;
        }
    }
    if(count1<count2)
    {
        while(count1!=count2)
        {
            temp2=temp2->next;
            count2--;
        }
    }    
    while(temp1!=NULL&&temp2!=NULL)
    {
        if(temp1==temp2)
        return temp1;
        temp1=temp1->next;
        temp2=temp2->next;
    }
    return NULL;
}

/*

Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.

 NOTE: If you are using any global variables, make sure to clear them in the constructor. 
Example :

Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 


		 
*/

class Node
{
    int key,value;
    Node next,previous;
    public Node(int key,int value)
    {
        this.key=key;
        this.value=value;
        next=null;
        previous=null;
    }
}

public class Solution {
    int cap,cacheSize;
    Node root,last;
    HashMap<Integer,Node> index;

    
    public Solution(int capacity) {
        cap=capacity;
        root=null;
        last=null;
        index=new HashMap<>();
        cacheSize=0;
        
    }
    
    public int get(int key) {
        
        
          int value=-1;
        if(index.containsKey(key))
        {
            Node temp=index.get(key);
            value=temp.value;
            if(temp==last&&temp.previous!=null)
                last=temp.previous;
            if(temp.next==null&&temp.previous!=null)
            {
                temp.previous.next=null;
                temp.previous=null;
                temp.next=root;
                root.previous=temp;
                root=temp;
            }
            else if(temp.next!=null&&temp.previous!=null)
            {
                temp.previous.next=temp.next;
                 temp.next.previous=temp.previous;
                temp.previous=null;
                temp.next=root;
                root.previous=temp;
                root=temp;
            }
        }
        
        return value;
        
    }
    
    public void set(int key, int value) {
         if(index.containsKey(key))
        {
            Node temp=index.get(key);
            if(temp==last&&temp.previous!=null)
                last=temp.previous;
            if(temp.next==null&&temp.previous!=null)
            {
                temp.previous.next=null;
                temp.previous=null;
                temp.next=root;
                root.previous=temp;
                root=temp;
            }
            else if(temp.next!=null&&temp.previous!=null)
            {
                temp.previous.next=temp.next;
                temp.next.previous=temp.previous;
                temp.previous=null;
                temp.next=root;
                root.previous=temp;
                root=temp;
            }
            temp.value=value;
        }
        else
        {
            Node newNode = new Node(key,value);
            if(cacheSize<cap)
            {
                index.put(key,newNode);
                if(root==null)
                {
                    root=newNode;
                    last=newNode;
                }
                else
                {
                    root.previous=newNode;
                    newNode.next=root;
                    root=newNode;
                }
                cacheSize++;
            }
            else
            {
                //System.out.println("hello");
                Node temp=last;
                index.remove(temp.key);
                last=temp.previous;
                temp.previous=null;
                if(last!=null)
                    last.next=null;
                if(last==null)
                    root=null;
                index.put(key,newNode);
                if(root==null){
                    root=newNode;
                    last=newNode;
                }
                else
                {
                    newNode.next=root;
                    root.previous=newNode;
                    root=newNode;
                }
                
                     
            }
        }
        
    }
}

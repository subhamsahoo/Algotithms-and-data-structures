/*

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.
Note that all the operations have to be constant time operations.

Questions to ask the interviewer :

Q: What should getMin() do on empty stack? 
A: In this case, return -1.

Q: What should pop do on empty stack? 
A: In this case, nothing. 

Q: What should top() do on empty stack?
A: In this case, return -1


*/


public class Solution {
    
   ArrayList<Integer> stack,minStack;
    int top;
    public Solution()
    {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
        top=-1;
    }

    public void push(int x) {
        if(top==-1)
        {
            stack.add(x);
            minStack.add(x);
        }
        else
        {
            stack.add(x);
            int min=minStack.get(top);
            if(x<min)
                min=x;
            minStack.add(min);
        }
        top++;
    }

    public void pop() {
        if(top>-1)
        {
            stack.remove(top);
            minStack.remove(top);
            top--;
        }
    }

    public int top() {
        if(top<0)
        return -1;
        return stack.get(top);
    }

    public int getMin() {
        if(top<0)
        return -1;
        return minStack.get(top);        
    }
}

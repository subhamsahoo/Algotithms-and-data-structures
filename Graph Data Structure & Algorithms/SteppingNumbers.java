/*

Given N and M find all stepping numbers in range N to M

The stepping number:

A number is called as a stepping number if the adjacent digits have a difference of 1.
e.g 123 is stepping number, but 358 is not a stepping number

Example:

N = 10, M = 20
all stepping numbers are 10 , 12 
Return the numbers in sorted order.

*/

public class Solution {
    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> result=new ArrayList();
        if(B<A)
        return result;
        if(A==0)
        result.add(0);
        for(int i=1;i<=9;i++)
        find(A,B,i,result);
        Collections.sort(result);
        return result;
    }
    
    void find(int r1,int r2,int num,ArrayList<Integer> result)
    {
        if(num>=r1&&num<=r2)
        result.add(num);
        if(num<r2)
        {
            int temp=num%10;
            if(temp!=0)
            find(r1,r2,(num*10)+temp-1,result);
            if(temp!=9)
            find(r1,r2,(num*10)+temp+1,result);
        }
    }
}

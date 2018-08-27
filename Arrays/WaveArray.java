/*

Given an array of integers, sort the array into a wave like array and return it, 
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
 NOTE : If there are multiple answers possible, return the one thats lexicographically smallest. 
So, in example case, you will return [2, 1, 4, 3] 


*/


public class Solution {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        int size=A.size();
        if(size==0)
        return A;
        Collections.sort(A);
        for(int i=1;i<size;i=i+2)
        {
            if(A.get(i)>A.get(i-1)||(i+1)<size&&A.get(i)>A.get(i+1))
            {
                if(i+1<size){
                int min=A.get(i-1)<A.get(i+1)?i-1:i+1;
                int temp=A.get(min);
                A.set(min,A.get(i));
                A.set(i,temp);
                }
                else
                {
                    int temp=A.get(i-1);
                    A.set(i-1,A.get(i));
                    A.set(i,temp);
                }
            }
        }
        return A;
    }
}

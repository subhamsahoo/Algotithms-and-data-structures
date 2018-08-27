/*


Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

The replacement must be in-place, do not allocate extra memory.

Examples:

1,2,3 → 1,3,2

3,2,1 → 1,2,3

1,1,5 → 1,5,1

20, 50, 113 → 20, 113, 50
Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.


*/

public class Solution {
    public void nextPermutation(ArrayList<Integer> a) {
        if(a.size()>1)
        {
            int i=a.size()-1;
            if(a.get(i)>a.get(i-1))
            {
                int temp=a.get(i);
                a.set(i,a.get(i-1));
                a.set(i-1,temp);
            }
            else
            {
                ArrayList<Integer> data=new ArrayList<>();
                data.add(a.get(i));
                data.add(a.get(i-1));
                i=i-2;
                int done=0;
                while(i>=0)
                {
                    if(data.get(data.size()-1)>a.get(i)){
                    for(int j=0;j<data.size();j++)
                    {
                        if(data.get(j)>a.get(i))
                        {
                            int temp=data.get(j);
                            data.set(j,a.get(i));
                            a.set(i,temp);
                            temp=i+1;
                            Collections.sort(data);
                            for(int k=0;k<data.size();k++)
                                a.set(temp++,data.get(k));
                            done=1;
                            break;
                        }
                    }
                    }
                    if(done==1)
                        break;
                    data.add(a.get(i));
                    i--;
                }
                if(done==0)
                    {
                        for(i=0;i<data.size();i++)
                        a.set(i,data.get(i));
                    }
            }
        }

        
    }
}

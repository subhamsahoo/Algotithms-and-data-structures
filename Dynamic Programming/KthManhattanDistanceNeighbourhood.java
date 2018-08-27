/*

Given a matrix M of size nxm and an integer K, find the maximum element in the K manhattan distance neighbourhood for all elements in nxm matrix. 
In other words, for every element M[i][j] find the maximum element M[p][q] such that abs(i-p)+abs(j-q) <= K.

Note: Expected time complexity is O(N*N*K)

Constraints:

1 <= n <= 300
1 <= m <= 300
1 <= K <= 300
0 <= M[i][j] <= 1000
Example:

Input:
M  = [[1,2,4],[4,5,8]] , K = 2

Output:
ans = [[5,8,8],[8,8,8]]


*/

public class Solution {
    public ArrayList<ArrayList<Integer>> solve(int A, ArrayList<ArrayList<Integer>> B) {
        int row=B.size(),col=B.get(0).size();
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        for(int i=0;i<row;i++)
        {
            ArrayList<Integer> res=new ArrayList<>();
            for(int j=0;j<col;j++)
            {
                //System.out.println("current Element "+i+" "+j);
                int max=B.get(i).get(j);
                
                //current line left
                int temp=Math.min(j,A);
                for(int k=1;k<=temp;k++)
                {
                   //System.out.println("current line left "+i+" "+(j-k));
                    if(B.get(i).get(j-k)>max)
                    max=B.get(i).get(j-k);
                }
                
                //current line right
                temp=Math.min(A,col-j-1);
                for(int k=1;k<=temp;k++)
                {
                    //System.out.println("current line right "+i+" "+(j+k));
                    if(B.get(i).get(j+k)>max)
                    max=B.get(i).get(j+k);
                }    
                
                //lower line
                temp=Math.min(A,row-i-1);
                for(int k=1;k<=temp;k++)
                {
                    //System.out.println("lower line"+(i+k)+" "+j);
                    if(B.get(i+k).get(j)>max)
                    max=B.get(i+k).get(j);
                    
                    //lower left
                    if(j>0)
                    {
                       int t1=Math.min(A,k+j);
                       int left=1;
                       for(int l=k+1;l<=t1;l++)
                       {
                           //System.out.println("lower line left"+(i+k)+" "+(j-left));
                           if(B.get(i+k).get(j-left)>max)
                           max=B.get(i+k).get(j-left);
                           left++;
                       }
                    }
                    //lower right
                    if(j<col-1)
                    {
                        int t1=Math.min(A,k+(col-j-1));
                        int right=1;
                        for(int l=k+1;l<=t1;l++)
                        {
                            //System.out.println("lower line right"+(i+k)+" "+(j+right));
                            if(B.get(i+k).get(j+right)>max)
                            max=B.get(i+k).get(j+right);
                            right++;
                        }
                    }
                }
                
                //upper line
                temp=Math.min(A,i);
                for(int k=1;k<=temp;k++)
                {
                    //System.out.println("upper line"+(i-k)+" "+j);
                    if(B.get(i-k).get(j)>max)
                    max=B.get(i-k).get(j);
                    
                    //lower left
                    if(j>0)
                    {
                       int t1=Math.min(A,k+j);
                       int left=1;
                       for(int l=k+1;l<=t1;l++)
                       {
                           //System.out.println("upper line left"+(i-k)+" "+(j-left));
                           if(B.get(i-k).get(j-left)>max)
                           max=B.get(i-k).get(j-left);
                           left++;
                       }
                    }
                    //lower right
                    if(j<col-1)
                    {
                        int t1=Math.min(A,k+(col-j-1));
                        int right=1;
                        for(int l=k+1;l<=t1;l++)
                        {
                            //System.out.println("upper line right"+(i-k)+" "+(j+right));
                            if(B.get(i-k).get(j+right)>max)
                            max=B.get(i-k).get(j+right);
                            right++;
                        }
                    }
                }
                
                
                res.add(max);
                
            }
            result.add(res);
        }
        return result;
    }
}

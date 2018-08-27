/*

Knight movement on a chess board

Given any source point and destination point on a chess board, we need to find whether Knight can move to the destination or not.

The above figure details the movements for a knight ( 8 possibilities ). Note that a knight cannot go out of the board.

If yes, then what would be the minimum number of steps for the knight to move to the said point.
If knight can not move from the source point to the destination point, then return -1

Input:

N, M, x1, y1, x2, y2
where N and M are size of chess board
x1, y1  coordinates of source point
x2, y2  coordinates of destination point
Output:

return Minimum moves or -1
Example

Input : 8 8 1 1 8 8
Output :  6


*/

/**
 * @input A : Integer
 * @input B : Integer
 * @input C : Integer
 * @input D : Integer
 * @input E : Integer
 * @input F : Integer
 * 
 * @Output Integer
 */
int min(int a,int b)
 {
     if(a<b)
     return a;
     return b;
 }
 
int find(int row,int col,int desRow,int desCol,int boardRow,int boardCol,int **visited)
    {
        if(row==desRow&&col==desCol){
        return 0;
        }
        if(row>0&&row<=boardRow&col>0&&col<=boardCol)
        {
            if(visited[row][col]!=0)
            return visited[row][col];
            visited[row][col]=-1;
            int minSteps=INT_MAX;
            int temp;
            temp=find(row-2,col+1,desRow,desCol,boardRow,boardCol,visited);
            if(temp!=-1)
                minSteps=min(minSteps,temp+1);
            temp=find(row-1,col+2,desRow,desCol,boardRow,boardCol,visited);
            if(temp!=-1)
                minSteps=min(minSteps,temp+1);
            temp=find(row+1,col+2,desRow,desCol,boardRow,boardCol,visited);
            if(temp!=-1)
                minSteps=min(minSteps,temp+1);
            temp=find(row+2,col+1,desRow,desCol,boardRow,boardCol,visited);
            if(temp!=-1)
                minSteps=min(minSteps,temp+1);
            temp=find(row+1,col-2,desRow,desCol,boardRow,boardCol,visited);
            if(temp!=-1)
                minSteps=min(minSteps,temp+1);
            temp=find(row+2,col-1,desRow,desCol,boardRow,boardCol,visited);
            if(temp!=-1)
                minSteps=min(minSteps,temp+1);
            temp=find(row-2,col-1,desRow,desCol,boardRow,boardCol,visited);
            if(temp!=-1)
                minSteps=min(minSteps,temp+1);
            temp=find(row-1,col-2,desRow,desCol,boardRow,boardCol,visited);
            if(temp!=-1)
                minSteps=min(minSteps,temp+1);
            if(minSteps==INT_MAX)
            return -1;
            else visited[row][col]=minSteps;
            return minSteps;
        }
            return -1;
    }
int knight(int A, int B, int C, int D, int E, int F) {
    if(A<1||B<1)
    return -1;
    if(C<1||C>A||D<1||D>B)
    return -1;
    if(E<1||E>A||F<1||F>B)
    return -1;
    int i,j;
    int **visited = (int **)calloc((A+2) , sizeof(int *));
    for ( i = 0; i < (A+2); i++) {
        visited[i] = (int *)calloc((B+2) , sizeof(int));
    }                
        return find(C,D,E,F,A,B,visited);
    return 0;
}

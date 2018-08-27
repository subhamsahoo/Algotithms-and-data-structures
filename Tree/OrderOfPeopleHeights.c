/*

You are given the following :

A positive number N
Heights : A list of heights of N persons standing in a queue
Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
You need to return list of actual order of persons’s height

Consider that heights will be unique

Example

Input : 
Heights: 5 3 2 6 1 4
InFronts: 0 1 2 0 3 2
Output : 
actual order is: 5 3 2 1 6 4 
So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence Infronts has 0 for him.

For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.

You can do similar inference for other people in the list.

*/.


/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * @input B : Integer array
 * @input n2 : Integer array's ( B ) length
 * 
 * @Output Integer array. You need to malloc memory, and fill the length in len1
 */
 
 void swap(int* a, int* b)
{
    int t = *a;
    *a = *b;
    *b = t;
}

int partition (int arr[],int arr2[], int low, int high)
{
    int pivot = arr[high];
    int i = (low - 1),j;  
 
    for (j = low; j <= high- 1; j++)
    {
        
        if (arr[j] <= pivot)
        {
            i++;    
            swap(&arr[i], &arr[j]);
            swap(&arr2[i], &arr2[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    swap(&arr2[i + 1], &arr2[high]);
    return (i + 1);
}
 
void quickSort(int arr[],int arr2[], int low, int high)
{
    if (low < high)
    {
        int pi = partition(arr,arr2, low, high);
        quickSort(arr,arr2, low, pi - 1);
        quickSort(arr,arr2, pi + 1, high);
    }
}
 
int* order(int* A, int n1, int* B, int n2, int *len1) {
    *len1=n1;
    if(n1<2)
    return A;
    int *result=(int*)calloc(sizeof(int),n1);
    quickSort(A,B,0,n1-1);
    int i,j;
    for( i=0;i<n1;i++)
    {
        int count=0;
        for( j=0;j<n1;j++)
        {
            if(result[j]==0)
            count++;
            if(count==B[i]+1)
            break;
        }
        result[j]=A[i];
    }
    return result;
}

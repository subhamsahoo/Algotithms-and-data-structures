/*

Given a collection of intervals, merge all overlapping intervals.

For example:

Given [1,3],[2,6],[8,10],[15,18],

return [1,6],[8,10],[15,18].

Make sure the returned intervals are sorted.

*/


/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 * };
 *
 * typedef struct Interval interval;
 */
/*
 * intervals : the array of interval
 * sz : number of entries in intervals
 * len : populate the length of returned array of intervals in len
 */
 
 
 int partition(interval *stud, int l, int h)
{
    int x = stud[h].start;
    int i = (l - 1),j;

    for ( j = l; j <= h - 1; j++)
    {
        if (stud[j].start <= x)
        {
            i++;
            interval temp = stud[j];
            stud[j] = stud[i];
            stud[i] = temp;
        }
    }
    interval temp = stud[i + 1];
    stud[i + 1] = stud[h];
    stud[h] = temp;
    return (i + 1);
}

 
void quickSort(interval *stud, int l, int h)
{
    if (l < h)
    {
                int p = partition(stud, l, h);
        quickSort(stud, l, p - 1);
        quickSort(stud, p + 1, h);
    }
}

 
interval* merge(interval *intervals, int sz, int *len) {
    if(sz==0)
    {
        *len=0;
        return NULL;
    }
    quickSort(intervals,0,sz-1);
    int i=0,starts=INT_MIN,ends=INT_MIN;
    *len=0;
    interval *result=(interval*)malloc(sizeof(interval)*2);
    while(i<sz)
    {
        while(i<sz)
        {
            if(intervals[i].start>starts&&intervals[i].start>ends)
            {
                if(starts==INT_MIN)
                {
                    starts=intervals[i].start;
                    ends=intervals[i].end;
                    i++;
                }
                else
                break;
            }
            else
            {
                int mins=starts<intervals[i].start?starts:intervals[i].start;
                int maxe=ends>intervals[i].end?ends:intervals[i].end;
                starts=mins;
                ends=maxe;
                i++;
            }
        }
        if(starts!=INT_MIN)
        {
            result[*len].start=starts;
            result[*len].end=ends;
            (*len)++;
        }
        starts=INT_MIN;
        ends=INT_MIN;
    }
    return result;
}

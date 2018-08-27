/*

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:

Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].

Example 2:

Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

Make sure the returned intervals are also sorted.

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

/**
 * intervals : the array of interval
 * sz : number of entries in intervals
 * newInterval : new Interval to be inserted
 * len : populate the length of returned array of intervals in len
 */
interval* insert(interval *intervals, int sz, interval newInterval, int *len) {
    if(newInterval.start>newInterval.end)
    {
        int temp=newInterval.start;
        newInterval.start=newInterval.end;
        newInterval.end=temp;
    }
    interval *result = (interval*)malloc(sizeof(interval)*(sz+1));
    int i=0,starts,ends,merge=0;
    *len=0;
    while(i<sz)
    {
        if(merge==0){
        if(intervals[i].start<=newInterval.start)
        {
            if(intervals[i].start==newInterval.start||intervals[i].end>newInterval.start)
            {
        starts=intervals[i].start<newInterval.start?intervals[i].start:newInterval.start;
        ends=intervals[i].end>newInterval.end?intervals[i].end:newInterval.end;
        i++;
        while(i<sz)
        {
            if(intervals[i].start>starts&&intervals[i].start>ends)
            break;
            else
            {
                starts=starts<intervals[i].start?starts:intervals[i].start;
                ends=ends>intervals[i].end?ends:intervals[i].end;
                i++;
            }
            
        }
        
        result[*len].start=starts;
        result[*len].end=ends;
        (*len)++;
        merge=1;
            }
        }
        else if(intervals[i].start>newInterval.start)
        {
            if((newInterval.start<intervals[i].start)&&(newInterval.end<intervals[i].start))
            {
        result[*len].start=newInterval.start;
        result[*len].end=newInterval.end;
        (*len)++;
        merge=1;
            }
            else
            {
                 starts=intervals[i].start<newInterval.start?intervals[i].start:newInterval.start;
        ends=intervals[i].end>newInterval.end?intervals[i].end:newInterval.end;
        i++;
        while(i<sz)
        {
            if(intervals[i].start>starts&&intervals[i].start>ends)
            break;
            else
            {
                starts=starts<intervals[i].start?starts:intervals[i].start;
                ends=ends>intervals[i].end?ends:intervals[i].end;
                i++;
            }
            
        }
        
        result[*len].start=starts;
        result[*len].end=ends;
        (*len)++;
        merge=1;
            }
        }
        }
    if(i<sz){
        result[*len].start=intervals[i].start;
        result[*len].end=intervals[i].end;
        (*len)++;
        i++;
    }
    }
    if(merge==0)
    {
    
        result[*len].start=newInterval.start;
        result[*len].end=newInterval.end;
        (*len)++;
    }
    return result;
}

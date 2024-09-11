//MAL CODIGO

/**
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

 

Constraints:

    0 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= starti <= endi <= 105
    intervals is sorted by starti in ascending order.
    newInterval.length == 2
    0 <= start <= end <= 105


**/

/**
//BUEN CÖDIGO

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] res = new int[n + 1][2];  // Array to store result intervals
        int i = 0, j = 0;
        
        // Add intervals that end before the new interval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            res[j++] = intervals[i++];
        }
        
        // Merge overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        
        // Add the merged interval
        res[j++] = newInterval;
        
        // Add the rest of the intervals
        while (i < n) {
            res[j++] = intervals[i++];
        }
        
        // Return the result array with only the used portion
        return Arrays.copyOf(res, j);
    }
}

**/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> merged = new ArrayList<>();
        int [] range  =  new int[2];
        boolean notChange = true;
        boolean done  =  false;

        if(intervals.length  ==  0){
            merged.add(newInterval);
            return  merged.toArray(new int[merged.size()][]);
        }if(intervals.length  == 1 && ((intervals[0][1] >= newInterval[0] && intervals[0][1] <= newInterval[1]) || //
                                       (newInterval[1] >= intervals[0][0] &&  newInterval[1] <= intervals[0][1]))){
            range[0] = intervals[0][0] > newInterval[0]  ? newInterval[0] : intervals[0][0];
            range[1] = intervals[0][1] > newInterval[1]  ? intervals[0][1] : newInterval[1];
            merged.add(range);
            return  merged.toArray(new int[merged.size()][]);
        }

        for(int i = 0; i < intervals.length; i++){
            System.out.println("newInterval[0]"+newInterval[0]+" newInterval[1]"+newInterval[1]);
            System.out.println("intervals[i][0]"+intervals[i][0]+" intervals[i][1]"+intervals[i][1]);
            System.out.println(notChange);
            if(done){
                merged.add(intervals[i]);
                continue;
            }
            if(newInterval[0] > intervals[i][1]){
                merged.add(intervals[i]);
                continue;
            }

            if(i + 1 == intervals.length && notChange && newInterval[1] < intervals[i][0]   ){
                merged.add(newInterval);
                merged.add(intervals[i]);
                done= true;
                continue;
            }
            
            if(i + 1 == intervals.length && notChange  &&  intervals.length  > 1){
                range[0] = intervals[i][0] < newInterval[0] ? intervals[i][0] : newInterval[0];
                range[1] = intervals[i][1] > newInterval[1] ? intervals[i][1] : newInterval[1];
                merged.add(range);
                notChange =  false;
                done = true;
                continue;
            }
            

            if(newInterval[0] < intervals[i][0] && notChange){
                range[0]  = newInterval[0];
                notChange = false;
            }
            if(intervals[i][0] <= newInterval[0] &&  newInterval[0] <= intervals[i][1] && notChange){
                range[0] =  intervals[i][0];
                notChange = false;
            }
            
            if(newInterval[1] < intervals[i][0]){
                range[1]  = newInterval[1];
                merged.add(range);
                merged.add(intervals[i]);
                done = true;
                continue;
            }
            if(intervals[i][0] <=  newInterval[1] &&  newInterval[1] <= intervals[i][1]){
                range[1] =  intervals[i][1];
                merged.add(range);
                done = true;
                continue;
            }
            if(i + 1 == intervals.length && !notChange){
                range[1] = intervals[i][1] > newInterval[1] ? intervals[i][1] : newInterval[1];
                merged.add(range);
                notChange =  false;
                done = true;
                continue;
            }
        }

        if(!done){
            merged.add(newInterval);
        }

        return  merged.toArray(new int[merged.size()][]);
    }
}

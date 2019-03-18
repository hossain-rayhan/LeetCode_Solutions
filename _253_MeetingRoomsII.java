/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        //return sortAndHeap(intervals);
        
        //https://leetcode.com/problems/meeting-rooms-ii/discuss/67855/Explanation-of-%22Super-Easy-Java-Solution-Beats-98.8%22-from-%40pinkfloyda
        
        return sortSolution(intervals);
    }
    
    //sort solution- much faster
    public int sortSolution(Interval[] intervals){
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        int l = intervals.length;
        int[] starts = new int[l];
        int[] ends = new int[l];
        for(int i = 0; i < l; i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int room = 0;
        int recentEnd = 0;
        for(int i = 0; i < l; i++){
            if(starts[i] < ends[recentEnd]){
                room++;
            }else{
                recentEnd++;
            }
        }
        return room;
    }
    
    //head solution- slower
    public int sortAndHeap(Interval[] intervals){
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        
        //we can solve using the heap
        //first sort the intervals by start time
        Arrays.sort(intervals, (a,b) -> a.start - b.start);
        
        //heap, using min end time
        PriorityQueue<Interval> heap = new PriorityQueue<>((a,b) -> a.end - b.end);
        heap.offer(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++){
            Interval over = heap.poll();
            
            if(intervals[i].start >= over.end){
                //no extra room need, use the free one
                heap.offer(intervals[i]);
            }else{
                //overlap, push both of them
                heap.offer(over);
                heap.offer(intervals[i]);
            }
        }
        return heap.size();
    }
}

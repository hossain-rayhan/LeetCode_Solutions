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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        int start = newInterval.start;
        int end = newInterval.end;
        
        //add all previous intervals which start before the new
        while(i < intervals.size() && intervals.get(i).end < start){
            result.add(intervals.get(i));
            i++;
        }
        
        //merger the overlaps and create only one
        while(i < intervals.size() && intervals.get(i).start <= end){
            start = Math.min(start, intervals.get(i).start);
            end = Math.max(end, intervals.get(i).end);
            i++;
        }
        result.add(new Interval(start, end));
        
        //add all the later intervals which start and end after the new
        while(i < intervals.size()){
            result.add(intervals.get(i));
            i++;
        }
        
        return result;
    }
}

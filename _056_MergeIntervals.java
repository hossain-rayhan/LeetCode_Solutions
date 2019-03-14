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
    public List<Interval> merge(List<Interval> intervals) {
        
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        for(Interval i : intervals){
            System.out.println(i.start + " " + i.end);
        }
        List<Interval> result = new ArrayList<>();
        
        for(Interval iv : intervals){
            if(result.isEmpty()){
                result.add(iv);
            }else{
                if(result.get(result.size()-1).end >= iv.start){
                    Interval temp = result.remove(result.size()-1);
                    result.add(new Interval(Math.min(temp.start, iv.start), Math.max(temp.end, iv.end)));
                }else{
                    result.add(iv);
                }
            }
        }
        
        return result;
    }
}

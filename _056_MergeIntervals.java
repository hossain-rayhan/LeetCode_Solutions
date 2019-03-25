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
        //return merge1(intervals);
        return merge2(intervals);
    }
    
    //sort start and end separately
    public List<Interval> merge2(List<Interval> intervals){
        int n = intervals.size();
	    int[] starts = new int[n];
	    int[] ends = new int[n];
	    for (int i = 0; i < n; i++) {
		    starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
	    }
	    Arrays.sort(starts);
	    Arrays.sort(ends);
	    // loop through
	    List<Interval> res = new ArrayList<Interval>();
	    for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
		    if (i == n - 1 || starts[i + 1] > ends[i]) {
			    res.add(new Interval(starts[j], ends[i]));
			    j = i + 1;
		    }
	    }
	    return res;
    }
    
    public List<Interval> merge1(List<Interval> intervals){
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

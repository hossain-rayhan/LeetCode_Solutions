
//https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/discuss/151685/Shortest-and-cleanest-Java-solution-so-far...


class Solution {
    public int search(ArrayReader reader, int target) {
        //for binary search we need the start and end index
        //to find the end index increase end exponentially
        //once the end is found, start is the value of previous end
        
        int end = 1;
        while(reader.get(end) < target){
            end = end << 1;
        }
        int start = end  >> 1;
        
        while(start <= end){
            int mid = (start+end)/2;
            int midValue = reader.get(mid);

            if(midValue == target){
                return mid;
            }else if(midValue > target){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}

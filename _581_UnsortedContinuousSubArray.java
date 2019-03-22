//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/discuss/103066/Ideas-behind-the-O(n)-two-pass-and-one-pass-solutions

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        //return find1(nums);
        
        return onePass(nums);
    }
    
    //O(n) one pass solution
    public int onePass(int[] nums){
        int i = 0, j = -1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int left = 0, right = nums.length-1; right >= 0; left++, right--){
            max = Math.max(max, nums[left]);
            if(nums[left] != max){
                j = left;
            }
            
            min = Math.min(min, nums[right]);
            if(nums[right] != min){
                i = right;
            }
        }
        return j - i + 1;
    }
    
    //Sort and search solution
    //Time: O(nlogn), Space: O(n)
    public int find1(int[] nums){
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        
        int begin = 0, end = nums.length - 1;
        while(begin < nums.length && (nums[begin] == sorted[begin])){
            begin++;
        }
        while(end > begin && (nums[end] == sorted[end])){
            end--;
        }
        
        return end - begin + 1;
    }
}

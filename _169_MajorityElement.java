class Solution {
    
    //for a given array we can have at most one majority element
    //Boyer-Moore Voting algorithm
    //Considering we always have an algoithm
    //Time Complexity O(N); Space: O(1)
    
    public int majorityElement(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        
        int majorityIndex = 0, count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[majorityIndex]){
                count++;
            }else{
                count--;
            }
            
            if(count == 0){
                majorityIndex = i;
                count++;
            }
        }
        return nums[majorityIndex];
    }
}

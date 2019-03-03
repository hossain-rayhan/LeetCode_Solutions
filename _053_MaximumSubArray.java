//kadane's algorithm- Maximum subarray sum

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        int maxGlobal = nums[0], maxEndingHere = 0;
        for(int i = 0; i < nums.length; i++){
            maxEndingHere = maxEndingHere + nums[i];
            
            if(maxEndingHere > maxGlobal){
                maxGlobal = maxEndingHere;
            }
            if(maxEndingHere < 0){
                maxEndingHere = 0;
            }
        }
        
        return maxGlobal;
    }
}

class Solution {
    public int dominantIndex(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return 0;
        }
        int maxIndex = 0, maxA = 0, maxB = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= maxA){
                maxB = maxA;
                maxA = nums[i];
                maxIndex = i;
            }else if(nums[i] >= maxB){
                maxB = nums[i];
            }
        }
        return maxA >= (maxB * 2)? maxIndex : -1;
    }
}

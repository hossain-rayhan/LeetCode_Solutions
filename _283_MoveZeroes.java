class Solution {
    public void moveZeroes(int[] nums) {
        
        //move the non-zero valuese to left
        int insertIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[insertIndex++] = nums[i];
            }
        }
        
        //fill-up the right sides with zero
        while(insertIndex < nums.length){
            nums[insertIndex++] = 0;
        }
        
    }
}

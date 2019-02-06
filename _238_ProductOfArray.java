class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        if(length == 0){
            return nums;
        }
        
        int[] suffix = new int[length];
        suffix[length-1] = 1;
        for(int i = length-2; i >= 0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        
        int prefix = 1;
        for(int i = 0; i < length; i++){
            int temp = prefix * nums[i];
            suffix[i] = prefix * suffix[i];
            prefix = temp;
        }
        
        return suffix;
    }
}
